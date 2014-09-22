package com.dreamheaven.user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.companyinfo.domain.CompanyInfo;
import com.dreamheaven.companyinfo.service.CompanyInfoService;
import com.dreamheaven.user.constant.UserConstant;
import com.dreamheaven.user.domain.User;
import com.dreamheaven.user.service.UserService;
import com.dreamheaven.userinfo.domain.UserInfo;
import com.dreamheaven.userinfo.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 6482277535109934664L;

	private User user;
	
	private String uid;
	
	private String maxUsers;
	
	private List<CompanyInfo> companyInfoList;
	
	private UserService userService ;
	
	private UserInfoService userInfoService ;
	
	private CompanyInfoService companyInfoService ;
	
	

	public String getMaxUsers() {
		return maxUsers;
	}

	public void setMaxUsers(String maxUsers) {
		this.maxUsers = maxUsers;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<CompanyInfo> getCompanyInfoList() {
		return companyInfoList;
	}

	public void setCompanyInfoList(List<CompanyInfo> companyInfoList) {
		this.companyInfoList = companyInfoList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	//login
	@Override
	public String execute() throws Exception {

		Map<String, Object> session = ActionContext.getContext().getSession();
		session.clear();
		user.setActive(null);
		user.setUserType(null);
		user.setUid(null);
		BeanUtils.copyProperties(user, user);
		if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassword())) {
			if (StringUtils.isBlank(user.getUserName())) {
				user.setErrorInfo("userName can't not be null");
			} 
			else if (StringUtils.isBlank(user.getPassword())) {
				user.setErrorInfo("password can't not be null");
			}
			session.put("username", user.getUserName());
			return UserConstant.FAILED;
		} else {
			
			//检验用户以及密码是否正确,如果正确则返回用户类型，如果错误则返回空
			if (StringUtils.isBlank(userService.checkUser(user))) {
				user.setErrorInfo("password is not correct!");
				return UserConstant.FAILED;
			}

			String userType = userService.checkUser(user);
			
			session.put("userName", user.getUserName());
			session.put("userType", user.getUserType());
			
			if (UserConstant.USER_PERSONAL_USERTYPE.equals(userType))
			{
				if(UserConstant.USER_NOTACTIVE_FLAG.equals(userService.getActiveStatus(user))){
					user.setErrorInfo("This count is not active.");
					return UserConstant.FAILED;
				}
				return LOGIN;
			} 
			else if (UserConstant.USER_COMPANY_USERTYPE.equals(userType)) 
			{
				if(UserConstant.USER_NOTACTIVE_FLAG.equals(userService.getActiveStatus(user))){
					user.setErrorInfo("This	 conunt is not active.");
					return UserConstant.COMPANYFAILED;
				}
				return UserConstant.COMPANY;
			}
			else if (UserConstant.USER_MANAGER_USERTYPE.equals(userType)) 
			{
				if(UserConstant.USER_NOTACTIVE_FLAG.equals(userService.getActiveStatus(user))){
					user.setErrorInfo("This conunt is not active.");
					return UserConstant.MANAGERFAILED;
				}
				return UserConstant.MANAGEMENT;
			}

			return UserConstant.FAILED;
		}
	}
	
	//logout
	public String logout(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.clear();
		return SUCCESS;
	}
	
	public String prepareToRegister()
	{
		
		List<CompanyInfo> companyInfoList = companyInfoService.queryCompanyInfo(new CompanyInfo());
		
		setCompanyInfoList(companyInfoList);
		
		return SUCCESS;
	}
	
	//查询当前公司下的所有员工信息(不包括未被激活帐号)
	public List<UserInfo> queryAllEmployeeInfo(CompanyInfo companyInfo){
		
		return null;
	}
	//删除本公司的某一位员工(包括未被激活帐号)
	public String deleteAnEmployee(){
		
		if(checkUserInCompany() == 0)
		{
			return null;
		}
		
		//删除该用户（但是保留用户资料）
		User employUser = new User();
		employUser.setUid(uid);
		userService.deleteUser(employUser);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		JSONObject obj = new JSONObject();
		obj.put("isSuccess", true);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println(obj);
		out.flush();
		out.close();
		
		return null;
		
	}
	//激活当前某一个员工申请的帐号，激活前需要判断当前用户是否达到了最大用户数
	public String activeAnEmployee(){
		
		if(checkUserInCompany() == 0)
		{
			return null;
		}
		//管理员分配给企业的最大用户数
		int maxUserCount = 0;
		if(null == CommonUtils.getCompanyInfoFromSession().getMaxUsers())
		{
			maxUserCount = 1;
		}else
		{
			maxUserCount = Integer.parseInt(CommonUtils.getCompanyInfoFromSession().getMaxUsers());
		}
		//计算当前公司名下用户数
		//先去userInfo表中找到所有公司名下用户的uid，然后在user表中计算uid匹配的用户数量并且active为1的用户总数
		UserInfo userInfo = new UserInfo();
		userInfo.setCompanyId(CommonUtils.getCompanyInfoFromSession().getCompanyId());
		List<UserInfo> userInfoList = userInfoService.queryUserInfo(userInfo);
		int nowUserCount = 0;
		for(UserInfo userInfoTemp : userInfoList)
		{
			User userTemp = new User();
			userTemp.setUid(userInfoTemp.getUid());
			userTemp.setActive(UserConstant.USER_ACTIVE_FLAG);
			userTemp = userService.detailUser(userTemp);
			if(null != userTemp)
			{
				nowUserCount++;
			}
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		JSONObject obj = new JSONObject();
		
		if(nowUserCount < maxUserCount)
		{
			//当前用户数量小于分配给公司的最大用户数，激活该用户
			user = new User();
			user.setUid(uid);
			userService.activeUser(user);
			obj.put("isSuccess", true);
		}
		else
		{
			obj.put("isSuccess", false);
		}
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println(obj);
		out.flush();
		out.close();
		
		return null;

	}
	//禁用掉当前某一个员工的帐号
	public String forbidAnEmployee(){
		
		if(checkUserInCompany() == 0)
		{
			return null;
		}
		user = new User();
		user.setUid(uid);
		userService.forbidUser(user);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		JSONObject obj = new JSONObject();
		obj.put("isSuccess", true);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println(obj);
		out.flush();
		out.close();
		
		return null;
	}
	
	//检测员工是否是本公司的
	public int checkUserInCompany(){
		//先判断是否有权限，即员工是否是本公司的
		UserInfo employeeUserInfo = new UserInfo();
		employeeUserInfo.setUid(uid);
		employeeUserInfo = userInfoService.detailUserInfo(employeeUserInfo);
		String employeeCompanyId = employeeUserInfo.getCompanyId();
		
		//如果公司id为空，或者被用户不是本公司的则返回0
		if(StringUtils.isBlank(employeeCompanyId) || !employeeCompanyId
				.equals(CommonUtils.getCompanyInfoFromSession().getCompanyId()))
		{
			return 0;
		}
		
		return 1;
	}
	
	public String activeCompany()
	{
		//激活公司帐号
		user = new User();
		user.setUid(uid);
		userService.activeUser(user);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		JSONObject obj = new JSONObject();
		obj.put("isSuccess", true);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println(obj);
		out.flush();
		out.close();
		return null;
	}
	public String logOffCompany()
	{
		//注销公司帐号
		user = new User();
		user.setUid(uid);
		userService.forbidUser(user);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		JSONObject obj = new JSONObject();
		obj.put("isSuccess", true);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println(obj);
		out.flush();
		out.close();
		return null;
	}

	
}
