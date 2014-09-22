package com.dreamheaven.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.dreamheaven.constant.Constant;
import com.dreamheaven.dao.UserTmpDao;
import com.dreamheaven.domain.User;
import com.dreamheaven.domain.UserTmp;
import com.dreamheaven.hibernate.HibernateSessionFactory;
import com.dreamheaven.utils.CommonUtils;

public class UserTmpDaoImpl implements UserTmpDao{

	private Session session;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public UserTmpDaoImpl() {
		session = HibernateSessionFactory.getSession();
	}

	private Map<String, String> getParamMap(UserTmp UserTmp) {
		paramMap.put(Constant.suid, UserTmp.getUid());
		paramMap.put(Constant.usersessionid, UserTmp.getUserSessionId());
		paramMap.put(Constant.starttime, UserTmp.getStartTime());
		return paramMap;
	}

	public void createUserTmp(UserTmp userTmp) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		userTmp = (UserTmp) session.merge(userTmp);
		session.save(userTmp);
		transaction.commit();

	}

	@SuppressWarnings("unchecked")
	public List<UserTmp> queryUserTmp(UserTmp UserTmp) {

		Criteria criteria = session.createCriteria(UserTmp.getClass());

		CommonUtils.setCriteria(getParamMap(UserTmp), criteria);

		return criteria.list();
	}

	public UserTmp detailUserTmp(UserTmp UserTmp) {
		Criteria criteria = session.createCriteria(UserTmp.getClass());
		CommonUtils.setCriteria(getParamMap(UserTmp), criteria);

		if (null != criteria.list()) {
			if(criteria.list().size() > 0){
				return (UserTmp) criteria.list().get(0);
			}
		}
		return null;
	}

	public int countUserTmp(UserTmp UserTmp) {
		Criteria criteria = session.createCriteria(UserTmp.getClass());

		criteria.setProjection(Projections.rowCount());

		CommonUtils.setCriteria(getParamMap(UserTmp), criteria);

		return ((Number) criteria.uniqueResult()).intValue();
	}

	public void deleteUserTmp(UserTmp UserTmp) {

		Transaction transaction = session.beginTransaction();
		transaction.begin();
		UserTmp = (UserTmp) session.merge(UserTmp);
		session.delete(UserTmp);
		transaction.commit();

	}

	public void updateUserTmp(UserTmp userTmp) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		userTmp = (UserTmp) session.merge(userTmp);
		session.save(userTmp);
		transaction.commit();
	}
}
