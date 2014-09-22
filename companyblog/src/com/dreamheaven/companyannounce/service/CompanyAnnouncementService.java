package com.dreamheaven.companyannounce.service;

import java.util.List;

import com.dreamheaven.companyannounce.domain.CompanyAnnouncement;

public interface CompanyAnnouncementService {
	
	List<CompanyAnnouncement> queryCompanyAnnouncement(CompanyAnnouncement companyAnnouncement);
	
	CompanyAnnouncement detailCompanyAnnouncement(CompanyAnnouncement companyAnnouncement);
	
	void modiyfCompanyAnnouncement(CompanyAnnouncement companyAnnouncement);
	
	void deleteCompanyAnnouncement(CompanyAnnouncement companyAnnouncement);
	
	void createCompanyAnnouncement(CompanyAnnouncement companyAnnouncement);
}
