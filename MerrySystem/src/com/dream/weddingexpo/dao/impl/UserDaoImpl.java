package com.dream.weddingexpo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dream.weddingexpo.bean.User;
import com.dream.weddingexpo.constant.Constants;
import com.dream.weddingexpo.dao.UserDao;
import com.dream.weddingexpo.utils.CommonUtils;

public class UserDaoImpl implements UserDao {

	private Session session;
	private Criteria criteria;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public UserDaoImpl() {
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		session = sessionFactory.openSession();
	}

	private Map<String, String> getUserParamMap(User user) {
		paramMap.put(Constants.User_userId, user.getUserId());
		paramMap.put(Constants.User_userName, user.getUserName());
		paramMap.put(Constants.User_userType, user.getUserType());
		paramMap.put(Constants.User_passwd, user.getPasswd());
		paramMap.put(Constants.User_isActive, user.getIsActive());
		return paramMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> userList(User user) {
		criteria = session.createCriteria(user.getClass());
		CommonUtils.setCriteria(getUserParamMap(user), criteria);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User detailUser(User user) {
		criteria = session.createCriteria(user.getClass());
		CommonUtils.setCriteria(getUserParamMap(user), criteria);
		List<User> userList = criteria.list();
		if (null != userList && !userList.isEmpty()) {
			return userList.get(0);
		}

		return null;
	}

	@Override
	public void addUser(User user) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		user = (User) session.merge(user);
		session.save(user);
		transaction.commit();
	}

	@Override
	public void deleteUser(User user) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		user = (User) session.merge(user);
		session.delete(user);
		transaction.commit();
	}

	@Override
	public User updateUser(User user) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		user = (User) session.merge(user);
		session.save(user);
		transaction.commit();
		return user;
	}

}
