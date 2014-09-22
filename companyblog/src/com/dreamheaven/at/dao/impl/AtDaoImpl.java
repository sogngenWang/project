package com.dreamheaven.at.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dreamheaven.at.constant.AtConstant;
import com.dreamheaven.at.dao.AtDao;
import com.dreamheaven.at.domain.At;
import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.companyinfo.domain.CompanyInfo;
import com.dreamheaven.hibernate.HibernateSessionFactory;

public class AtDaoImpl implements AtDao{

	private Session session;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public AtDaoImpl() {
		session = HibernateSessionFactory.getSession();
	}

	private Map<String, String> getParamMap(At at) {
		
		paramMap.put(AtConstant.AT_MID, at.getAtPK().getMid());
		paramMap.put(AtConstant.AT_ATUID, at.getAtPK().getAtUid());
		paramMap.put(AtConstant.AT_ATTYPE, at.getAtPK().getAtType());
		paramMap.put(AtConstant.AT_SEQNUM, at.getAtPK().getSeqNum());
		
		return paramMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<At> queryAt(At at) {
		
		Criteria criteria = session.createCriteria(at.getClass());
		
		CommonUtils.setCriteria(getParamMap(at), criteria);
		
		return criteria.list();
	}

	@Override
	public void createAt(At at) {
		
		Transaction transaction = session.beginTransaction();
		at = (At)session.merge(at);
		session.save(at);
		transaction.commit();
	}

	@Override
	public void deleteAt(At at) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		at = (At)session.merge(at);
		session.delete(at);
		transaction.commit();
	}
	
	
	
}
