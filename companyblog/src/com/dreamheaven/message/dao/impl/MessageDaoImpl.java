package com.dreamheaven.message.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.companyinfo.domain.CompanyInfo;
import com.dreamheaven.hibernate.HibernateSessionFactory;
import com.dreamheaven.message.constant.MessageConstant;
import com.dreamheaven.message.dao.MessageDao;
import com.dreamheaven.message.domain.Message;

public class MessageDaoImpl implements MessageDao {

	private Session session;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public MessageDaoImpl() {

		session = HibernateSessionFactory.getSession();
	}
	
	private Map<String, String> getParamMap(Message message) {
		paramMap.put(MessageConstant.MESSAGE_MID, message.getMid());
		paramMap.put(MessageConstant.MESSAGE_UID, message.getUid());
		paramMap.put(MessageConstant.MESSAGE_MCONTENT, message.getMcontent());
		paramMap.put(MessageConstant.MESSAGE_CREATETIME, message.getCreateTime());

		return paramMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> queryMessage(Message message) {
		Criteria criteria = session.createCriteria(message.getClass());
		CommonUtils.setCriteria(getParamMap(message), criteria);
		criteria.addOrder(Order.desc(MessageConstant.MESSAGE_CREATETIME));
		return criteria.list();
	}



	@Override
	public void createMessage(Message message) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		session.save(message);
		transaction.commit();
	}

	@Override
	public int countMessage(Message message) {
		Criteria criteria = session.createCriteria(message.getClass());
		CommonUtils.setCriteria(getParamMap(message), criteria);
		criteria.setProjection(Projections.rowCount());
		return ((Number) criteria.uniqueResult()).intValue();
	}

	@Override
	public void deleteMessage(Message message) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		message = (Message)session.merge(message);
		session.delete(message);
		transaction.commit();
	}

}
