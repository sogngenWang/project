package com.dreamheaven.userinfo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.dreamheaven.common.constant.CommonConstant;
import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.companyinfo.domain.CompanyInfo;
import com.dreamheaven.companyinfo.service.CompanyInfoService;
import com.dreamheaven.message.domain.Message;
import com.dreamheaven.message.service.MessageService;
import com.dreamheaven.relymessage.domain.RelyMessage;
import com.dreamheaven.relymessage.service.RelyMessageService;
import com.dreamheaven.user.constant.UserConstant;
import com.dreamheaven.user.domain.User;
import com.dreamheaven.user.service.UserService;
import com.dreamheaven.userinfo.constant.UserInfoConstant;
import com.dreamheaven.userinfo.domain.UserInfo;
import com.dreamheaven.userinfo.service.UserInfoService;
import com.dreamheaven.userinterest.domain.UserInterest;
import com.dreamheaven.userinterest.domain.UserInterestPK;
import com.dreamheaven.userinterest.service.UserInterestService;
import com.opensymphony.xwork2.ActionSupport;

public class UserInfoAction extends ActionSupport {

	private static final long serialVersionUID = 7550602528411457922L;
	private UserInterestService userInterestService ;
	private UserInfoService userInfoService ;
	private UserService userService ;
	private CompanyInfoService companyInfoService ;
	private MessageService messageService;
	private RelyMessageService relyMessageService;
	
	public User user;
	
	public UserInfo userInfo;

	private String uid;
	
	private List<CompanyInfo> companyInfoList;
	
	private String searchUserName;
	
	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public String getSearchUserName() {
		return searchUserName;
	}

	public void setSearchUserName(String searchUserName) {
		this.searchUserName = searchUserName;
	}

	public UserInterestService getUserInterestService() {
		return userInterestService;
	}

	public void setUserInterestService(UserInterestService userInterestService) {
		this.userInterestService = userInterestService;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public List<CompanyInfo> getCompanyInfoList() {
		return companyInfoList;
	}

	public void setCompanyInfoList(List<CompanyInfo> companyInfoList) {
		this.companyInfoList = companyInfoList;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String queryFansInfo() {
		// 获取当前用户的uid
		User tempUser = CommonUtils.getUserFromSession();
		String uid = tempUser.getUid();
		// get all fans' uid
		UserInterest userInterest = new UserInterest();
		UserInterestPK userInterestPK = new UserInterestPK();
		userInterestPK.setListenedId(uid);
		userInterest.setUserInterestPK(userInterestPK);

		List<UserInterest> fansList = userInterestService.queryUserInterest(userInterest);

		List<UserInfo> fansInfoList = new ArrayList<UserInfo>();

		for (UserInterest userInterestTemp : fansList) {
			
			String fansId = userInterestTemp.getUserInterestPK().getUid();
			

			UserInfo userInfoTemp = new UserInfo();

			userInfoTemp.setUid(fansId);

			userInfoTemp = userInfoService.detailUserInfo(userInfoTemp);
			
			//查询当前用户是否已经收听了该用户
			userInterest = new UserInterest();
			userInterestPK = new UserInterestPK();
			userInterestPK.setUid(uid);
			userInterestPK.setListenedId(fansId);
			userInterest.setUserInterestPK(userInterestPK);
			
			int count = userInterestService.countUserInterest(userInterest);

			if(count == 0)
			{
				userInfoTemp.setListenFlag("0");
			}
			else
			{
				userInfoTemp.setListenFlag("1");
			}
			
			fansInfoList.add(userInfoTemp);
		}
		
		user.setFansInfoList(fansInfoList);

		return SUCCESS;
	}

	public String queryAttentionInfo() {
		// 获取当前用户的uid
		User currentUser = CommonUtils.getUserFromSession();
		String uid = currentUser.getUid();
		// get all fans' uid
		UserInterest userInterest = new UserInterest();
		UserInterestPK userInterestPK = new UserInterestPK();
		userInterestPK.setUid(uid);
		userInterest.setUserInterestPK(userInterestPK);

		List<UserInterest> attentionList = userInterestService.queryUserInterest(userInterest);

		List<UserInfo> attentionInfoList = new ArrayList<UserInfo>();

		for (UserInterest userInterestTemp : attentionList) 
		{
			String attentionId = userInterestTemp.getUserInterestPK().getListenedId();

			UserInfo userInfoTemp = new UserInfo();

			userInfoTemp.setUid(attentionId);

			userInfoTemp = userInfoService.detailUserInfo(userInfoTemp);

			//查询当前用户是否已经收听了该用户
			userInterest = new UserInterest();
			userInterestPK = new UserInterestPK();
			userInterestPK.setUid(uid);
			userInterestPK.setListenedId(attentionId);
			userInterest.setUserInterestPK(userInterestPK);
			
			int count = userInterestService.countUserInterest(userInterest);

			if(count == 0)
			{
				userInfoTemp.setListenFlag("0");
			}
			else
			{
				userInfoTemp.setListenFlag("1");
			}
			
			attentionInfoList.add(userInfoTemp);
		}

		user.setAttentionInfoList(attentionInfoList);

		return SUCCESS;
	}
	
	public String queryAllSameCompanyUser(){
		//查询所有本公司的用户
		String companyId = CommonUtils.getCompanyInfoFromSession().getCompanyId();
		userInfo = new UserInfo();
		userInfo.setCompanyId(companyId);
		List<UserInfo> userInfoList = userInfoService.queryUserInfo(userInfo);
		
		userInfo.setUserInfoList(userInfoList);
		
		return SUCCESS;
	}
	
	public String queryAllSameCompanyNeedActiveUser(){
		//查询所有本公司还未激活的用户
		String companyId = CommonUtils.getCompanyInfoFromSession().getCompanyId();
		userInfo = new UserInfo();
		userInfo.setCompanyId(companyId);
		List<UserInfo> userInfoList = userInfoService.queryUserInfo(userInfo);
		List<UserInfo> userInfoListTemp = new ArrayList<UserInfo>();
		for(UserInfo userInfoTemp : userInfoList)
		{
			User userTemp = new User();
			userTemp.setUid(userInfoTemp.getUid());
			userTemp = userService.detailUser(userTemp);
			if(userTemp!=null && !UserInfoConstant.USER_ACTIVE.equals(userTemp.getActive()))
			{
				//如果用户未被激活则添加到list中，只显示未被激活的用户
				userInfoListTemp.add(userInfoTemp);
			}
		}
		
		userInfo.setUserInfoList(userInfoListTemp);
		return SUCCESS;
	}
	public String getSavePath()
	{
		String path = ServletActionContext.getServletContext().getRealPath("userheadimg");
		
		File headFileDir = new File(path);
		
		if(!headFileDir.exists())
		{
			headFileDir.mkdir();
		}
		
		return path;
	}
	
	public void upload(String uploadName)
	{
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {

			String path = getSavePath(); 
			
			inputStream = new FileInputStream(userInfo.getHeadFile());
			outputStream = new FileOutputStream(path + "\\" + uploadName);
			
			byte[] data = new byte[1024];
			int lenghth = 0;
			while ((lenghth = inputStream.read(data)) > 0) {
				outputStream.write(data, 0, lenghth);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != inputStream) {
					inputStream.close();
				}
				if (null != outputStream) {
					outputStream.close();

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String addPersonalUser()
	{
		try{
		//判断必填项是否为空，判断公司是否为空
		
		//先添加一个user,但是active=0
		User user = this.getUser();
		user.setUserType(UserConstant.USER_PERSONAL_USERTYPE);
		userService.addUserNotActive(user);
		//获取添加的uid
		String uid = userService.detailUser(user).getUid();
		//通过uid生成文件
		UserInfo userInfo = this.getUserInfo();
		//如果有上传头像，则通过uid生成文件
		if(null != userInfo.getHeadFile())
		{
			int index = StringUtils.lastIndexOf(userInfo.getHeadFileFileName(), ".");
			String postFix = userInfo.getHeadFileFileName().substring(index);
			String fileName = uid + postFix;
			upload(fileName);
			userInfo.setHeadImgPath(fileName);
		}
		//如果有输入日期，则格式化日期
		if(!StringUtils.isBlank(userInfo.getBirthday()))
		{
			DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
			Date birthdayDate = dateFormat1.parse(userInfo.getBirthday());
			DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");
			String birthday = dateFormat2.format(birthdayDate);
			userInfo.setBirthday(birthday);
		}
		userInfo.setUid(uid);
		//添加UserInfo
		userInfoService.createUserInfo(userInfo);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String userInfoAndWeibo()
	{
		//通过传过来的用户uid，然后从数据库冲查询该用户所属公司，如果该用户和当前登录用户的所属公司是同一个公司的话,
		//则查询该用户的个人信息，以及所有的微博信息，然后存在user对象中
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setUid(uid);
		companyInfo = companyInfoService.detailCompanyInfo(companyInfo);
		
		String currentUid = CommonUtils.getUserFromSession().getUid();
		userInfo = new UserInfo();
		userInfo.setUid(currentUid);
		userInfo = userInfoService.detailUserInfo(userInfo);
		
		if(companyInfo.getCompanyId().equals(userInfo.getCompanyId()))
		{
			//两个公司id相同说明查看的此人的信息跟当前登录用户是同一个公司，同一个公司则查看该uid对应的用户信息
			userInfo = new UserInfo();
			userInfo.setUid(uid);
			userInfo = userInfoService.detailUserInfo(userInfo);
			Message message = new Message();
			message.setUid(uid);
			List<Message> messageListTemp = messageService.queryMessage(message);
			
			RelyMessage relyMessage = null;
			for(Message messageTemp : messageListTemp)
			{
				relyMessage = new RelyMessage();
				relyMessage.getRelyMessagePK().setMid(messageTemp.getMid());
				List<RelyMessage> relyMessageListTemp = relyMessageService.queryRelyMessageByMid(relyMessage);
				messageTemp.setRelyMessageList(relyMessageListTemp);
			}
			
			user.setMessageList(messageListTemp);
			
			return SUCCESS;
		}
		
		
		return null;
	}
	
	public String detailPersonalInfoByUid(){
		//uid通过参宿传递进来
		//先通过uid获取用户图片以及用户名字，然后通过uid获取所有的微博以及回复信息，同首页显示
		queryUserInfo();
		
		
		return SUCCESS;
	}
	
	public String detailUserInfoByUid()
	{
		queryUserInfo();
		return SUCCESS;
	}
	
	public String detailUserInfoByImgId()
	{
		//headImg_
		uid = uid.substring(uid.lastIndexOf("_")+1);
		queryUserInfo();
		return SUCCESS;
	}
	
	public String detailUserInfoByAHref()
	{
		queryUserInfo();
		return SUCCESS;
	}
	
	public String detailMyInfo()
	{
		uid = CommonUtils.getUserFromSession().getUid();
		queryUserInfo();
		//user信息直接从session中获取
		return SUCCESS;
	}
	
	public String beforeToSearchUser()
	{
		//查询出当前所有同一个公司下的所有员工的个人信息，然后存到List里面
		
		userInfo.setUid(CommonUtils.getUserFromSession().getUid());
		List<UserInfo> userInfoTempList = userInfoService.queryUserInfo(userInfo);
		if( userInfoTempList.size() <=0 )
		{
			return SUCCESS;
		}
		userInfo = userInfoTempList.get(0);
		String companyId = userInfo.getCompanyId();
		userInfo = new UserInfo();
		userInfo.setCompanyId(companyId);
		CompanyInfo companyInfo = new CompanyInfo();
		companyInfo.setCompanyId(companyId);
		companyInfo = companyInfoService.detailCompanyInfo(companyInfo);
		List<UserInfo> userInfoList = userInfoService.queryUserInfo(userInfo);
		
		userInfo.setCompanyInfo(companyInfo);
		userInfo.setUserInfoList(userInfoList);
		
		return SUCCESS;
	}
	
	public String searchUserOfTheSameCompany()
	{
		try{
		//通过名字，查找公司员工信息
		UserInfo userInfoTemp = new UserInfo();
		userInfoTemp.setNickName(searchUserName);
		List<UserInfo> userInfoListTemp = userInfoService.queryUserInfo(userInfoTemp);

		JSONObject json = new JSONObject();
		
		if(userInfoListTemp.size() == 1)
		{
			userInfoTemp = userInfoListTemp.get(0);
//			CommonUtils.createJson(userInfoTemp.getClass(),json);
			json.put("uid",userInfoTemp.getUid());
			json.put("nickName",userInfoTemp.getNickName());
			json.put("age",userInfoTemp.getAge());
			json.put("sex",userInfoTemp.getSex());
			json.put("birthday",userInfoTemp.getBirthday());
			json.put("hoby",userInfoTemp.getHoby());
			json.put("headImgPath",userInfoTemp.getHeadImgPath());
			json.put("flag", "0");
		}
		else
		{
			json.put("flag", "1");
		}
		CommonUtils.generateJson(json);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	private void queryUserInfo()
	{
		userInfo = new UserInfo();
		userInfo.setUid(uid);
		userInfo = userInfoService.detailUserInfo(userInfo);
		companyInfoList = companyInfoService.queryCompanyInfo(new CompanyInfo());
	}
	
	
	
	
}
