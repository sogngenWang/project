package com.dream.weddingexpo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import com.dream.weddingexpo.bean.Top;
import com.dream.weddingexpo.constant.Constants;
import com.dream.weddingexpo.dao.TopDao;
import com.dream.weddingexpo.utils.CommonUtils;

public class TopDaoImpl implements TopDao {

	private Session session;
	private Criteria criteria;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public TopDaoImpl() {
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		session = sessionFactory.openSession();
	}

	private Map<String, String> getTopParamMap(Top top) {
		paramMap.put(Constants.Top_topId, top.getTopId());
		paramMap.put(Constants.Top_messageId, top.getMessageId());
		return paramMap;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Top> topList(Top top) {
		session.clear();
		criteria = session.createCriteria(top.getClass());
		CommonUtils.setCriteria(getTopParamMap(top), criteria);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Top detailTop(Top top) {
		session.clear();
		criteria = session.createCriteria(top.getClass());
		CommonUtils.setCriteria(getTopParamMap(top), criteria);
		List<Top> topList = criteria.list();
		if(null != topList && !topList.isEmpty()){
			return topList.get(0);
		}
		
		return null;
	}

	@Override
	public void addTop(Top top) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		top = (Top)session.merge(top);
		session.save(top);
		transaction.commit();
	}

	@Override
	public void deleteTop(Top top) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		top = (Top)session.merge(top);
		session.delete(top);
		transaction.commit();
	}

	@Override
	public Top updateTop(Top top) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		top = (Top)session.merge(top);
		session.save(top);
		transaction.commit();
		return top;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Top> listTopOrderById(Top top) {
		session.clear();
		criteria = session.createCriteria(top.getClass());
		CommonUtils.setCriteria(getTopParamMap(top), criteria);
		criteria.addOrder(Order.asc(Constants.Top_topId));
		return criteria.list();
	}


}
