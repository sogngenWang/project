package com.dreamheaven.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.dreamheaven.constant.Constant;
import com.dreamheaven.dao.ManuDao;
import com.dreamheaven.domain.Manu;
import com.dreamheaven.domain.User;
import com.dreamheaven.hibernate.HibernateSessionFactory;
import com.dreamheaven.utils.CommonUtils;

public class ManuDaoImpl implements ManuDao {

	private Session session;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public ManuDaoImpl() {
		session = HibernateSessionFactory.getSession();
	}

	private Map<String, String> getParamMap(Manu manu) {
		paramMap.put(Constant.classId, manu.getClassId());
		paramMap.put(Constant.className, manu.getClassName());
		return paramMap;
	}

	public void createManu(Manu manu) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		manu = (Manu) session.merge(manu);
		session.save(manu);
		transaction.commit();

	}

	@SuppressWarnings("unchecked")
	public List<Manu> queryManu(Manu manu) {

		Criteria criteria = session.createCriteria(manu.getClass());

		CommonUtils.setCriteria(getParamMap(manu), criteria);

		return criteria.list();
	}

	public Manu detailManu(Manu manu) {
		Criteria criteria = session.createCriteria(manu.getClass());
		CommonUtils.setCriteria(getParamMap(manu), criteria);

		if (null != criteria.list()) {
			if(criteria.list().size() > 0){
				return (Manu) criteria.list().get(0);
			}
		}
		return null;
	}

	public int countManu(Manu manu) {
		Criteria criteria = session.createCriteria(manu.getClass());

		criteria.setProjection(Projections.rowCount());

		CommonUtils.setCriteria(getParamMap(manu), criteria);

		return ((Number) criteria.uniqueResult()).intValue();
	}

	public void deleteManu(Manu manu) {

		Transaction transaction = session.beginTransaction();
		transaction.begin();
		manu = (Manu) session.merge(manu);
		session.delete(manu);
		transaction.commit();

	}

	public void updateManu(Manu manu) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		manu = (Manu) session.merge(manu);
		session.save(manu);
		transaction.commit();
	}

}
