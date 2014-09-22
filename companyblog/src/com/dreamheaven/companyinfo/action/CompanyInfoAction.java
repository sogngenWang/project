package com.dreamheaven.companyinfo.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.dreamheaven.common.constant.CommonConstant;
import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.companyinfo.constant.CompanyInfoConstant;
import com.dreamheaven.companyinfo.domain.CompanyInfo;
import com.dreamheaven.companyinfo.service.CompanyInfoService;
import com.dreamheaven.user.constant.UserConstant;
import com.dreamheaven.user.domain.User;
import com.dreamheaven.user.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyInfoAction extends ActionSupport {

	private CompanyInfoService companyInfoService ;
	
	private CompanyInfo companyInfo;
	
	private User user ;
	
	private String uid;
	
	private String maxUsers;

	private UserService userService;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getMaxUsers() {
		return maxUsers;
	}

	public void setMaxUsers(String maxUsers) {
		this.maxUsers = maxUsers;
	}

	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}
	
	//查询公司的信息,没有传入id则默认查询当前公司信息
	public CompanyInfo detailCompanyInfo(CompanyInfo companyInfo){
		
		if(StringUtils.isBlank(companyInfo.getUid()))
		{
			companyInfo = new CompanyInfo();
			companyInfo.setUid(CommonUtils.getUserFromSession().getUid());
		}
		
		companyInfo = companyInfoService.detailCompanyInfo(companyInfo);
		
		return companyInfo;
	}
	
	//获取所有公司信息
	public String getAllCompanyInfo()
	{
		CompanyInfo companyInfoTemp  = new CompanyInfo();
		List<CompanyInfo> companyInfoList = companyInfoService.queryCompanyInfo(companyInfoTemp);
		companyInfo.setCompanyInfoList(companyInfoList);
		
		return SUCCESS;
	}
	
	public String getNeedActiveCompany(){
		//先查出所有的公司信息
		CompanyInfo companyInfoNew  = new CompanyInfo();
		List<CompanyInfo> companyInfoList = companyInfoService.queryCompanyInfo(companyInfoNew);
		//遍历所有的List，然后将所有的active状态为0的公司加到另一个list中
		List<CompanyInfo> companyInfoListTemp = new ArrayList<CompanyInfo>();
		for(CompanyInfo companyInfoTemp : companyInfoList){
			User user = new User();
			user.setUid(companyInfoTemp.getUid());
			user.setActive(UserConstant.USER_NOTACTIVE_FLAG);
			user = userService.detailUser(user);
			if(null != user)
			{
				//user不为空说明不存在该uid并且未被激活的公司
				companyInfoListTemp.add(companyInfoTemp);
			}
		}
		
		companyInfo.setCompanyInfoList(companyInfoListTemp);
		
		return SUCCESS;
	}
	
	public String modifyCompanyMaxUsers()
	{
		//修改公司用户最大用户数，前台需要传递两个参数一个uid一个maxUsers
		CompanyInfo companyInfoTemp = new CompanyInfo();
		//先通过uid查出公司信息，然后
		companyInfoTemp.setUid(uid);
		companyInfoTemp = companyInfoService.detailCompanyInfo(companyInfoTemp);
		companyInfoTemp.setMaxUsers(maxUsers);
		companyInfoService.modiyfCompanyInfo(companyInfoTemp);
		//返回修改页面，再重新查询所有的公司信息
		companyInfoTemp  = new CompanyInfo();
		List<CompanyInfo> companyInfoList = companyInfoService.queryCompanyInfo(companyInfo);
		companyInfo.setCompanyInfoList(companyInfoList);
		
		return SUCCESS;
	}
	
	public String toModifyCompanyMaxUsers()
	{
		//跳转之前需要查询一下全部的公司信息
		companyInfo  = new CompanyInfo();
		List<CompanyInfo> companyInfoList = companyInfoService.queryCompanyInfo(companyInfo);
		companyInfo.setCompanyInfoList(companyInfoList);
		
		return SUCCESS;
	}
	
	public String addCompany()
	{
		user.setUserType(CompanyInfoConstant.COMPANY_USERTYPE);
		userService.addUserNotActive(user);
		
		user = userService.detailUser(user);
		String uid = user.getUid();
		companyInfo.setUid(uid);
		companyInfoService.createCompanyInfo(companyInfo);
		
		return SUCCESS;
	}

}
