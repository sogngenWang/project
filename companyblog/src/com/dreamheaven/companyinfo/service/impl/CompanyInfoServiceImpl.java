package com.dreamheaven.companyinfo.service.impl;

import java.util.List;

import com.dreamheaven.companyinfo.dao.CompanyInfoDao;
import com.dreamheaven.companyinfo.domain.CompanyInfo;
import com.dreamheaven.companyinfo.service.CompanyInfoService;

public class CompanyInfoServiceImpl implements CompanyInfoService{

	private CompanyInfoDao companyInfoDao;
	
	public CompanyInfoDao getCompanyInfoDao() {
		return companyInfoDao;
	}

	public void setCompanyInfoDao(CompanyInfoDao companyInfoDao) {
		this.companyInfoDao = companyInfoDao;
	}

	@Override
	public List<CompanyInfo> queryCompanyInfo(CompanyInfo companyInfo) {

		return companyInfoDao.queryCompanyInfo(companyInfo);
	}

	@Override
	public CompanyInfo detailCompanyInfo(CompanyInfo companyInfo) {
		
		return companyInfoDao.detailCompanyInfo(companyInfo);
	}

	@Override
	public void modiyfCompanyInfo(CompanyInfo companyInfo) {
		companyInfoDao.modiyfCompanyInfo(companyInfo);
		
	}

	@Override
	public void deleteCompanyInfo(CompanyInfo companyInfo) {
		companyInfoDao.deleteCompanyInfo(companyInfo);
	}

	@Override
	public void createCompanyInfo(CompanyInfo companyInfo) {
		companyInfoDao.createCompanyInfo(companyInfo);
	}

}
