package com.dreamheaven.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.dreamheaven.dao.OrderDao;
import com.dreamheaven.domain.Order;
import com.dreamheaven.service.OrderService;
import com.dreamheaven.utils.CommonUtils;

public class OrderServiceImpl implements OrderService{

	private static Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	public OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public boolean createOrder(Order order) {
		orderDao.createOrder(order);
		return false;
	}

	public boolean deleteOrder(Order order) {
		orderDao.deleteOrder(order);
		return false;
	}

	public Order detailOrder(Order order) {
		return orderDao.detailOrder(order);
	}

	public List<Order> queryAllOrders(Order order) {
		
		return orderDao.queryAllOrders(order);
	}

	public boolean updateOrder(Order order) {
		orderDao.updateOrder(order);
		return false;
	}

	/**
	 * 查询今日所有的订单详情
	 */
	public List<Order> queryTodayAllOrder(Order order) {
		//保证order为新的一个对象
		order = new Order();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		//格式化生成的时间戳，以%结尾，查询数据库的时候使用模糊查询
		order.setOrderTime(sdf.format(calendar.getTime())+"%");
		return orderDao.queryLikeAllOrder(order);
	}
	
	public List<Order> queryOrderByDate(Order order) {
		String orderTime = order.getOrderTime();
		order = new Order();
		//格式化生成的时间戳，以%结尾，查询数据库的时候使用模糊查询
		if(StringUtils.isBlank(orderTime)){
			return orderDao.queryAllOrders(order);
		}
		if(orderTime.contains("?")){
			orderTime.replace('?', '_');
			order.setOrderTime(orderTime+"%");
		}else{
			order.setOrderTime(orderTime+"%");
		}
		return orderDao.queryLikeAllOrder(order);
	}


	public void printOrder(Order order) {
		//查询获取该条记录的详情
		if(StringUtils.isBlank(order.getOrderDetail())){
			order = detailOrder(order);
		}
		System.out.println(order.getOrderDetail());
		if(StringUtils.isNotBlank(order.getOrderDetail())){
			CommonUtils.printPageByString(order.getOrderDetail());
		}
	}
	


}
