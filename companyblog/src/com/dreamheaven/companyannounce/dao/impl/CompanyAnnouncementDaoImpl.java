package com.dreamheaven.companyannounce.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.companyannounce.constant.CompanyAnnounceConstant;
import com.dreamheaven.companyannounce.dao.CompanyAnnouncementDao;
import com.dreamheaven.companyannounce.domain.CompanyAnnouncement;
import com.dreamheaven.hibernate.HibernateSessionFactory;

public class CompanyAnnouncementDaoImpl implements CompanyAnnouncementDao {

	private Session session;
	
	private Map<String,String> paramMap = new HashMap<String,String>();


	public CompanyAnnouncementDaoImpl()
	{
		session = HibernateSessionFactory.getSession();
	}
	
	private Map<String, String> getParamMap(CompanyAnnouncement companyAnnouncement) {
		
		paramMap.put(CompanyAnnounceConstant.COMPANYANNOUNCE_AID,companyAnnouncement.getAid());
		paramMap.put(CompanyAnnounceConstant.COMPANYANNOUNCE_COMPANYID,companyAnnouncement.getCompanyId());
		paramMap.put(CompanyAnnounceConstant.COMPANYANNOUNCE_ANNCONTENT,companyAnnouncement.getAnnContent());
		
		return paramMap;
	}

	@Override
	public List<CompanyAnnouncement> queryCompanyAnnouncement(
			CompanyAnnouncement companyAnnouncement) {
		
		Criteria criteria = session.createCriteria(companyAnnouncement.getClass());
		
		CommonUtils.setCriteria(getParamMap(companyAnnouncement), criteria);
		
		return criteria.list();
	}

	@Override
	public CompanyAnnouncement detailCompanyAnnouncement(
			CompanyAnnouncement companyAnnouncement) {
		
		Criteria criteria = session.createCriteria(companyAnnouncement.getClass());

		CommonUtils.setCriteria(getParamMap(companyAnnouncement), criteria);

		if(criteria.list().size()>0)
		{
			return (CompanyAnnouncement) criteria.list().get(0);
		}
		
		return null;
	}

	@Override
	public void modiyfCompanyAnnouncement(CompanyAnnouncement companyAnnouncement) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		companyAnnouncement = (CompanyAnnouncement)session.merge(companyAnnouncement);
		session.save(companyAnnouncement);
		transaction.commit();
	}

	@Override
	public void deleteCompanyAnnouncement(CompanyAnnouncement companyAnnouncement) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		companyAnnouncement = (CompanyAnnouncement)session.merge(companyAnnouncement);
		session.delete(companyAnnouncement);
		transaction.commit();
		
	}

	@Override
	public void createCompanyAnnouncement(CompanyAnnouncement companyAnnouncement) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		companyAnnouncement = (CompanyAnnouncement)session.merge(companyAnnouncement);
		session.save(companyAnnouncement);
		transaction.commit();
		
	}
	
}
