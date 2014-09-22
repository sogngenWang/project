package com.dreamheaven.companyannounce.service.impl;

import java.util.List;

import com.dreamheaven.companyannounce.dao.CompanyAnnouncementDao;
import com.dreamheaven.companyannounce.domain.CompanyAnnouncement;
import com.dreamheaven.companyannounce.service.CompanyAnnouncementService;

public class CompanyAnnouncementServiceImpl implements CompanyAnnouncementService{
	
	private CompanyAnnouncementDao companyAnnouncementDao;

	public CompanyAnnouncementDao getCompanyAnnouncementDao() {
		return companyAnnouncementDao;
	}

	public void setCompanyAnnouncementDao(
			CompanyAnnouncementDao companyAnnouncementDao) {
		this.companyAnnouncementDao = companyAnnouncementDao;
	}

	@Override
	public List<CompanyAnnouncement> queryCompanyAnnouncement(
			CompanyAnnouncement companyAnnouncement) {
		return companyAnnouncementDao.queryCompanyAnnouncement(companyAnnouncement);
	}

	@Override
	public CompanyAnnouncement detailCompanyAnnouncement(
			CompanyAnnouncement companyAnnouncement) {
		return companyAnnouncementDao.detailCompanyAnnouncement(companyAnnouncement);
	}

	@Override
	public void modiyfCompanyAnnouncement(
			CompanyAnnouncement companyAnnouncement) {
		companyAnnouncementDao.modiyfCompanyAnnouncement(companyAnnouncement);
		
	}

	@Override
	public void deleteCompanyAnnouncement(
			CompanyAnnouncement companyAnnouncement) {
		companyAnnouncementDao.deleteCompanyAnnouncement(companyAnnouncement);
	}

	@Override
	public void createCompanyAnnouncement(
			CompanyAnnouncement companyAnnouncement) {
		companyAnnouncementDao.createCompanyAnnouncement(companyAnnouncement);
	}
	
	
}
