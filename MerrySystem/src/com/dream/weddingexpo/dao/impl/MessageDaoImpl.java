package com.dream.weddingexpo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.OrderBy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import com.dream.weddingexpo.bean.Message;
import com.dream.weddingexpo.constant.Constants;
import com.dream.weddingexpo.dao.MessageDao;
import com.dream.weddingexpo.service.impl.MessageServiceImpl;
import com.dream.weddingexpo.utils.CommonUtils;

public class MessageDaoImpl implements MessageDao {
	public static final Log LOG = LogFactory.getLog(MessageDaoImpl.class);
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
		paramMap.put(Constants.MESSAGE_USERID, message.getUserId());
		paramMap.put(Constants.MESSAGE_MESSAGECONTENTPATH, message.getMessageContentPath());
		paramMap.put(Constants.MESSAGE_MESSAGETITLE, message.getMessageTitle());
		paramMap.put(Constants.MESSAGE_CREATETIME, message.getCreateTime());
		paramMap.put(Constants.MESSAGE_LASTUPDATETIME, message.getLastUpdateTime());
		return paramMap;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> messageList(Message message) {
		session.clear();
		criteria = session.createCriteria(message.getClass());
		CommonUtils.setCriteria(getMessageParamMap(message), criteria);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Message detailMessage(Message message) {
		session.clear();
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
		LOG.info("DAO addMessage " + message);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		message = (Message)session.merge(message);
		session.save(message);
		transaction.commit();
	}

	@Override
	public void deleteMessage(Message message) {
		LOG.info("DAO deleteMessage " + message);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		message = (Message)session.merge(message);
		session.delete(message);
		transaction.commit();
	}

	@Override
	public Message updateMessage(Message message) {
		LOG.info("DAO updateMessage " + message);
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		message = (Message)session.merge(message);
		session.save(message);
		transaction.commit();
		return message;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> messageListOrderByTime(Message message) {
		criteria = session.createCriteria(message.getClass());
		CommonUtils.setCriteria(getMessageParamMap(message), criteria);
		criteria.addOrder(Order.desc(Constants.MESSAGE_CREATETIME));
		return criteria.list();
	}


}
