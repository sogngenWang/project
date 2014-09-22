package com.dreamheaven.user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.companyannounce.domain.CompanyAnnouncement;
import com.dreamheaven.hibernate.HibernateSessionFactory;
import com.dreamheaven.user.constant.UserConstant;
import com.dreamheaven.user.dao.UserDao;
import com.dreamheaven.user.domain.User;

public class UserDaoImpl implements UserDao {

	private Session session;
	private Map<String,String> paramMap = new HashMap<String,String>();
	

	public UserDaoImpl() {
		session = HibernateSessionFactory.getSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchUser(User user) {

		Criteria criteria = session.createCriteria(user.getClass());
		CommonUtils.setCriteria(getParamMap(user), criteria);
		
		return criteria.list();
	}

	@Override
	public void update(User user) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		user = (User)session.merge(user);
		session.save(user);
		transaction.commit();
	}

	@Override
	public void delete(User user) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		user = (User)session.merge(user);
		session.delete(user);
		transaction.commit();
	}

	@Override
	public void create(User user) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		user = (User)session.merge(user);
		session.save(user);
		transaction.commit();
	}

	@Override
	public int count(User user) {
		return 0;
	}

	private Map<String,String> getParamMap(User user)
	{
		paramMap.put(UserConstant.USER_UID, user.getUid());
		paramMap.put(UserConstant.USER_USERNAME, user.getUserName());
		paramMap.put(UserConstant.USER_PASSWORD, user.getPassword());
		paramMap.put(UserConstant.USER_USERTYPE, user.getUserType());
		paramMap.put(UserConstant.USER_ACTIVE, user.getActive());
		
		return paramMap;
	}

	@Override
	public User detailUser(User user) {
		
		Criteria criteria = session.createCriteria(user.getClass());
		CommonUtils.setCriteria(getParamMap(user), criteria);
		
		if(null != criteria.list() && !criteria.list().isEmpty())
		{
			return (User) criteria.list().get(0);
		}
		
		return null;
	}
	
	

}
