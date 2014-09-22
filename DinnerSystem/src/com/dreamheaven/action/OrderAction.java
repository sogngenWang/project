package com.dreamheaven.action;

import java.util.List;

import com.dreamheaven.domain.Order;
import com.dreamheaven.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	
	private Order order;
	private OrderService orderService;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public String printOrder(){
		//打印订单
		orderService.printOrder(order);
		return "success";
	}
	
	public String queryTodayAllOrder(){
		order.setOrderList(orderService.queryTodayAllOrder(order));
		return "success";
	}
	
	public String queryOrderByDate(){
		order.setOrderList(orderService.queryOrderByDate(order));
		return "success";
	}
	
}
