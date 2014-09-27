package com.dream.weddingexpo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dream.weddingexpo.bean.Kinds;
import com.dream.weddingexpo.constant.Constants;
import com.dream.weddingexpo.dao.KindsDao;
import com.dream.weddingexpo.utils.CommonUtils;

public class KindsDaoImpl implements KindsDao {

	private Session session;
	private Criteria criteria;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public KindsDaoImpl() {
//		session = HibernateSessionFactory.getSession();
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		session = sessionFactory.openSession();
	}

	private Map<String, String> getKindsParamMap(Kinds kinds) {
		paramMap.put(Constants.KINDS_KINDSID, kinds.getKindsId());
		paramMap.put(Constants.KINDS_KINDSNAME, kinds.getKindsName());
		paramMap.put(Constants.KINDS_KINDSSTORE, kinds.getKindsStore());
		return paramMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kinds> kindsList(Kinds kinds) {
		criteria = session.createCriteria(kinds.getClass());
		CommonUtils.setCriteria(getKindsParamMap(kinds), criteria);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Kinds detailKinds(Kinds kinds) {
		criteria = session.createCriteria(kinds.getClass());
		CommonUtils.setCriteria(getKindsParamMap(kinds), criteria);
		List<Kinds> kindsList = criteria.list();
		if(null != kindsList && !kindsList.isEmpty()){
			return kindsList.get(0);
		}
		
		return null;
	}

	@Override
	public void addKinds(Kinds kinds) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		kinds = (Kinds)session.merge(kinds);
		session.save(kinds);
		transaction.commit();
	}

	@Override
	public void deleteKinds(Kinds kinds) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		kinds = (Kinds)session.merge(kinds);
		session.delete(kinds);
		transaction.commit();
	}

	@Override
	public Kinds updateKinds(Kinds kinds) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		kinds = (Kinds)session.merge(kinds);
		session.save(kinds);
		transaction.commit();
		return kinds;
	}

}
