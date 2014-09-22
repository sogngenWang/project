package com.dreamheaven.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dish implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6414301700494860484L;
	private String dishId;
	private String dishName;
	private String classId;
	private String dishCash;
	// ***********************
	private List<Dish> dishList = new ArrayList<Dish>();
	private List<Ingredient> ingredientList = new ArrayList<Ingredient>();
	
	
	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public List<Dish> getDishList() {
		return dishList;
	}

	public void setDishList(List<Dish> dishList) {
		this.dishList = dishList;
	}

	public String getDishId() {
		return dishId;
	}

	public void setDishId(String dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getDishCash() {
		return dishCash;
	}

	public void setDishCash(String dishCash) {
		this.dishCash = dishCash;
	}

}
