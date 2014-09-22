package com.dreamheaven.action;

import java.util.List;

import com.dreamheaven.domain.Dish;
import com.dreamheaven.domain.Ingredient;
import com.dreamheaven.domain.Manu;
import com.dreamheaven.domain.Order;
import com.dreamheaven.service.DishService;
import com.dreamheaven.service.IngredientService;
import com.dreamheaven.service.ManuService;
import com.dreamheaven.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

public class ManuAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4611000533226188061L;
	private DishService dishService;
	private Dish dish;
	private Ingredient ingredient;
	private IngredientService ingredientService;
	private OrderService orderService;
	private Order order;
	private Manu manu;
	private ManuService manuService;
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
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

	public Manu getManu() {
		return manu;
	}

	public void setManu(Manu manu) {
		this.manu = manu;
	}

	public ManuService getManuService() {
		return manuService;
	}

	public void setManuService(ManuService manuService) {
		this.manuService = manuService;
	}

	public String queryManu() {
		// 查询所有的菜单分类
		List<Manu> manuList = manuService.queryAllManus(manu);
		
		manu.setManuList(manuList);
		// 遍历每个菜单类，查找每个菜名
		for (Manu manuTemp : manuList) {
			Dish dishTmp = new Dish();
			dishTmp.setClassId(manuTemp.getClassId());
			List<Dish> dishList = dishService.queryAllDishs(dishTmp);
			System.out.println("||||"+dishList.size());
			// 遍历每个菜名，查找每个配菜名
			for (Dish dishTemp : dishList) {
				Ingredient ingredientTemp = new Ingredient();
				ingredientTemp.setDishId(dishTemp.getDishId());
				dishTemp.setIngredientList(ingredientService.queryAllIngredients(ingredientTemp));
				System.out.println("****"+dishTemp.getIngredientList().size());
			}
			manuTemp.setDishList(dishList);
		}
		
		return "success";
	}
}
