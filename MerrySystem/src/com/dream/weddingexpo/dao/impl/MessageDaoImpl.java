package com.dream.weddingexpo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.dream.weddingexpo.bean.Message;
import com.dream.weddingexpo.constant.Constants;
import com.dream.weddingexpo.dao.MessageDao;
import com.dream.weddingexpo.utils.CommonUtils;

public class MessageDaoImpl implements MessageDao {

	private Session session;
	private Criteria criteria;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public MessageDaoImpl() {
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		session = sessionFactory.openSession();
	}

	private Map<String, String> getMessageParamMap(Message message) {
		paramMap.put(Constants.MESSAGE_MESSAGEID, message.getMessageId());
		paramMap.put(Constants.MESSAGE_STOREID, message.getStoreId());
		paramMap.put(Constants.MESSAGE_MESSAGECONTENTPATH, message.getMessageContentPath());
		paramMap.put(Constants.MESSAGE_MESSAGETITLE, message.getMessageTitle());
		return paramMap;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> messageList(Message message) {
		criteria = session.createCriteria(message.getClass());
		CommonUtils.setCriteria(getMessageParamMap(message), criteria);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Message detailMessage(Message message) {
		criteria = session.createCriteria(message.getClass());
		CommonUtils.setCriteria(getMessageParamMap(message), criteria);
		List<Message> messageList = criteria.list();
		if(null != messageList && !messageList.isEmpty()){
			return messageList.get(0);
		}
		
		return null;
	}

	@Override
	public void addMessage(Message message) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		message = (Message)session.merge(message);
		session.save(message);
		transaction.commit();
	}

	@Override
	public void deleteMessage(Message message) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		message = (Message)session.merge(message);
		session.delete(message);
		transaction.commit();
	}

	@Override
	public Message updateMessage(Message message) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		message = (Message)session.merge(message);
		session.save(message);
		transaction.commit();
		return message;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> listMessageStoreIdNotNull(Message message) {
		criteria = session.createCriteria(message.getClass());
		criteria.add(Restrictions.isNull(Constants.MESSAGE_STOREID)); 
		return criteria.list();
	}

}
