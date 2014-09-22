package com.dreamheaven.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.dreamheaven.constant.Constant;
import com.dreamheaven.dao.UserDao;
import com.dreamheaven.domain.User;
import com.dreamheaven.hibernate.HibernateSessionFactory;
import com.dreamheaven.utils.CommonUtils;

public class UserDaoImpl implements UserDao {

	private Session session;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public UserDaoImpl() {
		session = HibernateSessionFactory.getSession();
	}

	private Map<String, String> getParamMap(User user) {
		paramMap.put(Constant.nuid, user.getUid());
		paramMap.put(Constant.username, user.getUsername());
		paramMap.put(Constant.password, user.getPassword());
		paramMap.put(Constant.userType, user.getUserType());
		return paramMap;
	}

	public void createLogin(User user) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		user = (User) session.merge(user);
		session.save(user);
		transaction.commit();

	}

	@SuppressWarnings("unchecked")
	public List<User> queryUser(User user) {

		Criteria criteria = session.createCriteria(user.getClass());

		CommonUtils.setCriteria(getParamMap(user), criteria);

		return criteria.list();
	}

	public User detailUser(User user) {
		Criteria criteria = session.createCriteria(user.getClass());
		CommonUtils.setCriteria(getParamMap(user), criteria);

		if (null != criteria.list()) {
			if(criteria.list().size() > 0){
				return (User) criteria.list().get(0);
			}
		}
		return null;
	}

	public int countUser(User user) {
		Criteria criteria = session.createCriteria(user.getClass());

		criteria.setProjection(Projections.rowCount());

		CommonUtils.setCriteria(getParamMap(user), criteria);

		return ((Number) criteria.uniqueResult()).intValue();
	}

	public void deleteUser(User user) {

		Transaction transaction = session.beginTransaction();
		transaction.begin();
		user = (User) session.merge(user);
		session.delete(user);
		transaction.commit();

	}

	public void updateUser(User user) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		user = (User) session.merge(user);
		session.save(user);
		transaction.commit();
	}

}
