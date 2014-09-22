package com.dreamheaven.service;

import java.util.List;

import com.dreamheaven.domain.Order;

public interface OrderService {

	Order detailOrder(Order order);

	boolean createOrder(Order order);

	boolean deleteOrder(Order order);

	boolean updateOrder(Order order);

	List<Order> queryAllOrders(Order order);

	List<Order> queryTodayAllOrder(Order order);
	
	void printOrder(Order order);

	List<Order> queryOrderByDate(Order order);

}
