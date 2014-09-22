package com.dreamheaven.userinterest.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.hibernate.HibernateSessionFactory;
import com.dreamheaven.userinterest.constant.UserInterestConstant;
import com.dreamheaven.userinterest.dao.UserInterestDao;
import com.dreamheaven.userinterest.domain.UserInterest;

public class UserInterestDaoImpl implements UserInterestDao {

	private Session session;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public UserInterestDaoImpl() {
		session = HibernateSessionFactory.getSession();
	}

	private Map<String, String> getParamMap(UserInterest userInterest) {
		
		paramMap.put(UserInterestConstant.USERINTEREST_UID, userInterest
				.getUserInterestPK().getUid());
		paramMap.put(UserInterestConstant.USERINTEREST_Listened, userInterest
				.getUserInterestPK().getListenedId());

		return paramMap;
	}


	@Override
	public void createUserInterest(UserInterest userInterest) {
		
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		userInterest = (UserInterest)session.merge(userInterest);
		session.save(userInterest);
		transaction.commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInterest> queryUserInterest(UserInterest userInterest) {
		
		Criteria criteria = session.createCriteria(userInterest.getClass());
		
		CommonUtils.setCriteria(getParamMap(userInterest), criteria);
		
		
		return criteria.list();
	}

	@Override
	public UserInterest detailUserInterest(UserInterest userInterest) {
		
		Criteria criteria = session.createCriteria(userInterest.getClass());
		
		CommonUtils.setCriteria(getParamMap(userInterest), criteria);
		
		if(null != criteria.list())
		{
			return (UserInterest) criteria.list().get(0);
		}
		
		return null;
	}

	@Override
	public int countUserInterest(UserInterest userInterest) {
		Criteria criteria = session.createCriteria(userInterest.getClass());

		criteria.setProjection(Projections.rowCount());
		
		CommonUtils.setCriteria(getParamMap(userInterest), criteria);

		return ((Number) criteria.uniqueResult()).intValue();
	}

	@Override
	public void deleteUserInterest(UserInterest userInterest) {
		
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		userInterest = (UserInterest)session.merge(userInterest);
		session.delete(userInterest);
		transaction.commit();
		
	}
	

}
