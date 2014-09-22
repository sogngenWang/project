package com.dreamheaven.companyinfo.service;

import java.util.List;

import com.dreamheaven.companyinfo.domain.CompanyInfo;

public interface CompanyInfoService {
	
	List<CompanyInfo> queryCompanyInfo(CompanyInfo companyInfo);
	
	CompanyInfo detailCompanyInfo(CompanyInfo companyInfo);
	
	void modiyfCompanyInfo(CompanyInfo companyInfo);
	
	void deleteCompanyInfo(CompanyInfo companyInfo);
	
	void createCompanyInfo(CompanyInfo companyInfo);
	
}
