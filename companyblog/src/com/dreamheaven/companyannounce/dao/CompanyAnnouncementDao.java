package com.dreamheaven.companyannounce.dao;

import java.util.List;

import com.dreamheaven.companyannounce.domain.CompanyAnnouncement;

public interface CompanyAnnouncementDao {
	
	List<CompanyAnnouncement> queryCompanyAnnouncement(CompanyAnnouncement companyAnnouncement);
	
	CompanyAnnouncement detailCompanyAnnouncement(CompanyAnnouncement companyAnnouncement);
	
	void modiyfCompanyAnnouncement(CompanyAnnouncement companyAnnouncement);
	
	void deleteCompanyAnnouncement(CompanyAnnouncement companyAnnouncement);
	
	void createCompanyAnnouncement(CompanyAnnouncement companyAnnouncement);
}
