package com.dreamheaven.action;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.dreamheaven.domain.Dish;
import com.dreamheaven.domain.Ingredient;
import com.dreamheaven.domain.Order;
import com.dreamheaven.service.DishService;
import com.dreamheaven.service.IngredientService;
import com.dreamheaven.service.OrderService;
import com.dreamheaven.utils.CommonUtils;
import com.opensymphony.xwork2.ActionSupport;

public class DishAction extends ActionSupport {

	private static final long serialVersionUID = -2644196050737184495L;
	private static Logger logger = Logger.getLogger(DishAction.class);
	private DishService dishService;
	private Dish dish;
	private Ingredient ingredient;
	private IngredientService ingredientService;
	private OrderService orderService;
	private Order order;
	private String dishMessage;
	
	
	public String getDishMessage() {
		return dishMessage;
	}

	public void setDishMessage(String dishMessage) {
		this.dishMessage = dishMessage;
	}

	public IngredientService getIngredientService() {
		return ingredientService;
	}

	public void setIngredientService(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	public DishService getDishService() {
		return dishService;
	}

	public void setDishService(DishService dishService) {
		this.dishService = dishService;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public String orderDinner() {
		//生成订单
		String orderTime = CommonUtils.generateDateString(new Date());
		List<Dish> dishList = CommonUtils.generateDishListFromMessage(dishMessage);
		long orderCash = Long.valueOf(order.getOrderCash());
		StringBuffer sb = new StringBuffer();
		sb.append("orderState:");
		if(null == order.getOrderState()){
			sb.append("1");
		}else{
			sb.append(order.getOrderState());
		}
		sb.append("\n");
		for(Dish dishTmp : dishList){
//			orderCash += Long.valueOf(dishTmp.getDishCash());
			sb.append(dishTmp.getDishName()).append(":").append(dishTmp.getDishCash()).append("\n");
			for(Ingredient ingredientTmp : dishTmp.getIngredientList()){
				sb.append("  ").append(ingredientTmp.getIngredientName()).append(":").append(ingredientTmp.getIngredientCash()).append("\n");
//				orderCash += Long.valueOf(ingredientTmp.getIngredientCash());
			}

		}
		sb.append("\n")
		.append("\n")
		.append("\n")
		.append("\t")
	  	.append("orderTime:" + orderTime)
	  	.append("\n")
		.append("\t")
		.append("orderCash:" + orderCash)
	  ;
		logger.info(sb.toString());
		//如果未设置，则设置订单状态为未支付状态
		if(null == order.getOrderState()){
			order.setOrderState("1");	
		}
		System.out.println("order detail's length is " + sb.toString().length());
		order.setOrderDetail(sb.toString());
		order.setOrderTime(orderTime);
		order.setOrderCash(orderCash+"");
		orderService.createOrder(order);
		
		return "success";
	}
	
	
}
