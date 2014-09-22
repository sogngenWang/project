package com.dreamheaven.relymessage.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.hibernate.HibernateSessionFactory;
import com.dreamheaven.relymessage.constant.RelyMessageConstant;
import com.dreamheaven.relymessage.dao.RelyMessageDao;
import com.dreamheaven.relymessage.domain.RelyMessage;

public class RelyMessageDaoImpl implements RelyMessageDao{
	
	private Session session;
	
	private Map<String,String> paramMap = new HashMap<String,String>();
	
	public RelyMessageDaoImpl(){
		session = HibernateSessionFactory.getSession();
	}
	
	private Map<String, String> getParamMap(RelyMessage relyMessage) {
		
		paramMap.put(RelyMessageConstant.RELYMESSAGE_MID, relyMessage.getRelyMessagePK().getMid());
		paramMap.put(RelyMessageConstant.RELYMESSAGE_RELYSEQNUM, relyMessage.getRelyMessagePK().getRelySeqNum());
		paramMap.put(RelyMessageConstant.RELYMESSAGE_UID, relyMessage.getUid());
		paramMap.put(RelyMessageConstant.RELYMESSAGE_RELYCONTENT, relyMessage.getRelyContent());
		paramMap.put(RelyMessageConstant.RELYMESSAGE_RELYTIME, relyMessage.getRelyTime());
		
		return paramMap;
	}

	@Override
	public int countRelyMessage(RelyMessage relyMessage) {
		
		Criteria criteria = session.createCriteria(relyMessage.getClass());
		
		criteria.setProjection(Projections.rowCount());
		CommonUtils.setCriteria(getParamMap(relyMessage), criteria);
		criteria.addOrder(Order.desc(RelyMessageConstant.RELYMESSAGE_RELYTIME));
		
		return ((Number)criteria.uniqueResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelyMessage> queryRelyMessage(RelyMessage relyMessage) {
		
		Criteria criteria = session.createCriteria(relyMessage.getClass());
		CommonUtils.setCriteria(getParamMap(relyMessage), criteria);

		return criteria.list();
	}

	@Override
	public void createRelyMessage(RelyMessage relyMessage) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		relyMessage = (RelyMessage)session.merge(relyMessage);
		session.save(relyMessage);
		transaction.commit();
	}

	@Override
	public void deleteRelyMessage(RelyMessage relyMessage) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		relyMessage = (RelyMessage)session.merge(relyMessage);
		session.delete(relyMessage);
		transaction.commit();
	}

}
