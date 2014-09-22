package com.dreamheaven.common.action;

import java.util.List;

import com.dreamheaven.common.constant.CommonConstant;
import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.companyannounce.domain.CompanyAnnouncement;
import com.dreamheaven.companyannounce.service.CompanyAnnouncementService;
import com.dreamheaven.companyinfo.domain.CompanyInfo;
import com.dreamheaven.companyinfo.service.CompanyInfoService;
import com.dreamheaven.message.domain.Message;
import com.dreamheaven.message.service.MessageService;
import com.dreamheaven.relymessage.service.RelyMessageService;
import com.dreamheaven.user.domain.User;
import com.dreamheaven.userinfo.domain.UserInfo;
import com.dreamheaven.userinfo.service.UserInfoService;
import com.dreamheaven.userinterest.domain.UserInterest;
import com.dreamheaven.userinterest.domain.UserInterestPK;
import com.dreamheaven.userinterest.service.UserInterestService;
import com.opensymphony.xwork2.ActionSupport;

public class CommonAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 336891045966124389L;
	
	private UserInfoService userInfoService ;
	private MessageService messageService ;
	private RelyMessageService relyMessageService ;
	private UserInterestService userInterestService ;
	private CompanyInfoService companyInfoService;
	private CompanyAnnouncementService companyAnnouncementService;
	
	private User user;
	private CompanyInfo companyInfo;
	private CompanyAnnouncement companyAnnouncement;
	
	private String actionFlag;


	public CompanyInfoService getCompanyInfoService() {
		return companyInfoService;
	}

	public void setCompanyInfoService(CompanyInfoService companyInfoService) {
		this.companyInfoService = companyInfoService;
	}

	public CompanyAnnouncementService getCompanyAnnouncementService() {
		return companyAnnouncementService;
	}

	public void setCompanyAnnouncementService(
			CompanyAnnouncementService companyAnnouncementService) {
		this.companyAnnouncementService = companyAnnouncementService;
	}

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

	public CompanyAnnouncement getCompanyAnnouncement() {
		return companyAnnouncement;
	}

	public void setCompanyAnnouncement(CompanyAnnouncement companyAnnouncement) {
		this.companyAnnouncement = companyAnnouncement;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public RelyMessageService getRelyMessageService() {
		return relyMessageService;
	}

	public void setRelyMessageService(RelyMessageService relyMessageService) {
		this.relyMessageService = relyMessageService;
	}

	public UserInterestService getUserInterestService() {
		return userInterestService;
	}

	public void setUserInterestService(UserInterestService userInterestService) {
		this.userInterestService = userInterestService;
	}

	public String getActionFlag() {
		return actionFlag;
	}

	public void setActionFlag(String actionFlag) {
		this.actionFlag = actionFlag;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public String forward()
	{
		if(CommonConstant.PERSONAL_ACTIONFLAG.equals(actionFlag))
		{
			return CommonConstant.LOGIN_PERSONALLOGIN;
		}
		if(CommonConstant.COMPANY_ACTIONFLAG.equals(actionFlag))
		{
			return  CommonConstant.LOGIN_COMPANYLOGIN;
		}
		if(CommonConstant.MANAGER_ACTIONFLAG.equals(actionFlag))
		{
			return  CommonConstant.LOGIN_MANAGERLOGIN;
		}
		return null;
	}

	@Override
	public String execute() throws Exception {
		//prepare data to main.jsp page

		user = CommonUtils.getUserFromSession();
		UserInfo userInfo = new UserInfo();
		userInfo.setUid(user.getUid());
		
		//query detail userInfo 
		userInfo = userInfoService.detailUserInfo(userInfo);
		
		//query person who is in the same company by random
		UserInfo userInfoInSanmeCompany = new UserInfo();
		userInfoInSanmeCompany.setUid(userInfo.getUid());
		userInfoInSanmeCompany.setCompanyId(userInfo.getCompanyId());
		List<UserInfo> userInfoList = userInfoService.getOhtersInofInSameCompany(userInfoInSanmeCompany);
		user.setUserInfoList(userInfoList);
		user.setUserInfo(userInfo);
		
		//query all my message
		Message message = new Message();
		message.setUid(user.getUid());
		List<Message> messageList = messageService.queryMessage(message);
		
		//Collections.reverse(messageList);
		user.setMessageList(messageList);
		user.setMessageCount(messageList == null ? CommonConstant.ZERO_MESSAGELIST : String.valueOf(messageList.size()));
		
		//query message if has rely message
		if(null != messageList && !messageList.isEmpty())
		{
			relyMessageService.checkRelyMessageByMid(messageList);
		}
		
		//my fans and my attention 
		int attentionCount;
		int fansCount;
		UserInterest userInterest = new UserInterest();
		UserInterestPK userInterestPK = new UserInterestPK();
		userInterestPK.setUid(user.getUid());
		userInterest.setUserInterestPK(userInterestPK);
		attentionCount = userInterestService.countAttention(userInterest);
		user.setAttentionCount(String.valueOf(attentionCount));
		userInterest.getUserInterestPK().setListenedId(user.getUid());
		fansCount = userInterestService.countFans(userInterest);
		user.setFansCount(String.valueOf(fansCount));
		
		
		return SUCCESS;
	}
	
	public String companyMain(){
		//先查询本公司的信息
		user = CommonUtils.getUserFromSession();
		companyInfo = new CompanyInfo();
		companyInfo.setUid(user.getUid());
		companyInfo = companyInfoService.detailCompanyInfo(companyInfo);
		
		CommonUtils.getSession().put("companyInfo", companyInfo);
		
		return SUCCESS;
	}
	
	public String managerMain(){
		//获取管理员昵称
		user = CommonUtils.getUserFromSession();


		return SUCCESS;
	}
	
	public String queryMessageAndRely()
	{
		user = CommonUtils.getUserFromSession();
		//query all my message
		Message message = new Message();
		message.setUid(user.getUid());
		List<Message> messageList = messageService.queryMessage(message);
		
		//Collections.reverse(messageList);
		user.setMessageList(messageList);
		user.setMessageCount(messageList == null ? CommonConstant.ZERO_MESSAGELIST : String.valueOf(messageList.size()));
		
		//query message if has rely message
		if(null != messageList && !messageList.isEmpty())
		{
			relyMessageService.checkRelyMessageByMid(messageList);
		}
		
		return SUCCESS;
	}
	
}
