package com.dreamheaven.companyannounce.action;

import java.util.List;

import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.companyannounce.domain.CompanyAnnouncement;
import com.dreamheaven.companyannounce.service.CompanyAnnouncementService;
import com.dreamheaven.companyinfo.domain.CompanyInfo;
import com.dreamheaven.user.domain.User;
import com.dreamheaven.userinfo.domain.UserInfo;
import com.dreamheaven.userinfo.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class CompanyAnnouncementAction extends ActionSupport {
	
	private CompanyAnnouncementService companyAnnouncementService;
	
	private CompanyAnnouncement companyAnnouncement;
	
	private String messageText;
	
	private UserInfoService userInfoService;
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}


	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}


	public String getMessageText() {
		return messageText;
	}


	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}


	public CompanyAnnouncementService getCompanyAnnouncementService() {
		return companyAnnouncementService;
	}


	public void setCompanyAnnouncementService(
			CompanyAnnouncementService companyAnnouncementService) {
		this.companyAnnouncementService = companyAnnouncementService;
	}


	public CompanyAnnouncement getCompanyAnnouncement() {
		return companyAnnouncement;
	}


	public void setCompanyAnnouncement(CompanyAnnouncement companyAnnouncement) {
		this.companyAnnouncement = companyAnnouncement;
	}


	public String queryAnnouncement(){
		CompanyInfo companyInfo = CommonUtils.getCompanyInfoFromSession();
		String companyId = null;
		if(null == companyInfo)
		{
			//如果为空，则查找
			User user = CommonUtils.getUserFromSession();
			String uid = user.getUid();
			UserInfo userInfo = new UserInfo();
			userInfo.setUid(uid);
			userInfo = userInfoService.detailUserInfo(userInfo);
			companyId = userInfo.getCompanyId();
		}else
		{
			companyId = companyInfo.getCompanyId();
		}
		companyAnnouncement = new CompanyAnnouncement();
		companyAnnouncement.setCompanyId(companyId);
		List<CompanyAnnouncement> companyAnnouncementList = 
				companyAnnouncementService.queryCompanyAnnouncement(companyAnnouncement);
		
		companyAnnouncement.setCompanyAnnouncementList(companyAnnouncementList);
		
		return SUCCESS;
	}
	
	public String createAnn()
	{
		companyAnnouncement.setAnnContent(messageText);
		companyAnnouncement.setCompanyId(CommonUtils.getCompanyInfoFromSession().getCompanyId());
		companyAnnouncementService.createCompanyAnnouncement(companyAnnouncement);
		return SUCCESS;
	}
}
