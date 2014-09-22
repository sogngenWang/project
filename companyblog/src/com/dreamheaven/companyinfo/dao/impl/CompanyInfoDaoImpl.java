package com.dreamheaven.companyinfo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.companyinfo.constant.CompanyInfoConstant;
import com.dreamheaven.companyinfo.dao.CompanyInfoDao;
import com.dreamheaven.companyinfo.domain.CompanyInfo;
import com.dreamheaven.hibernate.HibernateSessionFactory;
import com.dreamheaven.relymessage.domain.RelyMessage;

public class CompanyInfoDaoImpl implements CompanyInfoDao{


	private Session session;
	
	private Map<String,String> paramMap = new HashMap<String,String>();


	public CompanyInfoDaoImpl()
	{
		session = HibernateSessionFactory.getSession();
	}
	
	private Map<String, String> getParamMap(CompanyInfo companyInfo) {
		
		paramMap.put(CompanyInfoConstant.COMPANYINFO_COMPANYID,companyInfo.getCompanyId());
		paramMap.put(CompanyInfoConstant.COMPANYINFO_UID,companyInfo.getUid());
		paramMap.put(CompanyInfoConstant.COMPANYINFO_COMPANYNAME,companyInfo.getCompanyName());
		paramMap.put(CompanyInfoConstant.COMPANYINFO_MAXUSERS,companyInfo.getMaxUsers());
		paramMap.put(CompanyInfoConstant.COMPANYINFO_COMPANYDESCRIBE,companyInfo.getCompanyDescribe());
		paramMap.put(CompanyInfoConstant.COMPANYINFO_COMPANYADDRESS,companyInfo.getCompanyAddress());
		paramMap.put(CompanyInfoConstant.COMPANYINFO_COMPANYCONTACT,companyInfo.getCompanyContact());
		
		return paramMap;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyInfo> queryCompanyInfo(CompanyInfo companyInfo) {
		
		Criteria criteria = session.createCriteria(companyInfo.getClass());
		
		CommonUtils.setCriteria(getParamMap(companyInfo), criteria);
		
		return criteria.list();
	}

	@Override
	public CompanyInfo detailCompanyInfo(CompanyInfo companyInfo) {
		
		Criteria criteria = session.createCriteria(companyInfo.getClass());

		CommonUtils.setCriteria(getParamMap(companyInfo), criteria);

		if(criteria.list().size()>0)
		{
			return (CompanyInfo) criteria.list().get(0);
		}
		
		return null;
	}

	@Override
	public void modiyfCompanyInfo(CompanyInfo companyInfo) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		companyInfo = (CompanyInfo)session.merge(companyInfo);
		session.save(companyInfo);
		transaction.commit();
	}

	@Override
	public void deleteCompanyInfo(CompanyInfo companyInfo) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		companyInfo = (CompanyInfo)session.merge(companyInfo);
		session.delete(companyInfo);
		transaction.commit();
	}

	@Override
	public void createCompanyInfo(CompanyInfo companyInfo) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		companyInfo = (CompanyInfo)session.merge(companyInfo);
		session.save(companyInfo);
		transaction.commit();
	}
	
}
