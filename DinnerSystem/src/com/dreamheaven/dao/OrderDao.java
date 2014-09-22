package com.dreamheaven.dao;

import java.util.List;

import com.dreamheaven.domain.Order;



public interface OrderDao {

	int countOrder(Order order);

	void deleteOrder(Order order);

	void createOrder(Order order);
	
	void updateOrder(Order order);
	
	Order detailOrder(Order order);
	
	List<Order> queryAllOrders(Order order) ;

	List<Order> queryLikeAllOrder(Order order);
	
	
}
