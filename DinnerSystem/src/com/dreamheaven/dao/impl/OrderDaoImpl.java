package com.dreamheaven.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.dreamheaven.constant.Constant;
import com.dreamheaven.dao.OrderDao;
import com.dreamheaven.domain.Order;
import com.dreamheaven.hibernate.HibernateSessionFactory;
import com.dreamheaven.utils.CommonUtils;

public class OrderDaoImpl implements OrderDao {

	private Session session;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public OrderDaoImpl() {
		session = HibernateSessionFactory.getSession();
	}

	private Map<String, String> getParamMap(Order order) {
		paramMap.clear();
		paramMap.put(Constant.orderId, order.getOrderId());
		paramMap.put(Constant.orderState, order.getOrderState());
		paramMap.put(Constant.orderCash, order.getOrderCash());
		paramMap.put(Constant.orderTime, order.getOrderTime());
		paramMap.put(Constant.orderDetail, order.getOrderDetail());
		return paramMap;
	}

	public void createOrder(Order order) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		order = (Order) session.merge(order);
		session.save(order);
		transaction.commit();

	}

	@SuppressWarnings("unchecked")
	public List<Order> queryAllOrders(Order order) {

		Criteria criteria = session.createCriteria(order.getClass());

		CommonUtils.setCriteria(getParamMap(order), criteria);

		return criteria.list();
	}

	public Order detailOrder(Order order) {
		Criteria criteria = session.createCriteria(order.getClass());
		CommonUtils.setCriteria(getParamMap(order), criteria);

		if (null != criteria.list()) {
			if (criteria.list().size() > 0) {
				return (Order) criteria.list().get(0);
			}
		}
		return null;
	}

	public int countOrder(Order order) {
		Criteria criteria = session.createCriteria(order.getClass());

		criteria.setProjection(Projections.rowCount());

		CommonUtils.setCriteria(getParamMap(order), criteria);

		return ((Number) criteria.uniqueResult()).intValue();
	}

	public void deleteOrder(Order order) {

		Transaction transaction = session.beginTransaction();
		transaction.begin();
		order = (Order) session.merge(order);
		session.delete(order);
		transaction.commit();

	}

	public void updateOrder(Order order) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		order = (Order) session.merge(order);
		session.save(order);
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Order> queryLikeAllOrder(Order order) {
		
		Criteria criteria = session.createCriteria(order.getClass());
		criteria.add(Restrictions.like(Constant.orderTime, order.getOrderTime()));

		return criteria.list();
	}

}
