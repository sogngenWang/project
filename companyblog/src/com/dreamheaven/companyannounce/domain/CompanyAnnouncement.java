package com.dreamheaven.companyannounce.domain;

import java.util.ArrayList;
import java.util.List;

public class CompanyAnnouncement {

	private String aid;
	
	private String companyId;

	private String annContent;
	
	//----------------------------------
	private  List<CompanyAnnouncement>  companyAnnouncementList = new ArrayList<CompanyAnnouncement>();
	

	public List<CompanyAnnouncement> getCompanyAnnouncementList() {
		return companyAnnouncementList;
	}

	public void setCompanyAnnouncementList(
			List<CompanyAnnouncement> companyAnnouncementList) {
		this.companyAnnouncementList = companyAnnouncementList;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getAnnContent() {
		return annContent;
	}

	public void setAnnContent(String annContent) {
		this.annContent = annContent;
	}
	
	
}
