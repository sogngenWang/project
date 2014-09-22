package com.dreamheaven.domain;

import java.io.Serializable;

public class Ingredient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8817087835383974317L;
	private String ingredientId;
	private String ingredientName;
	private String dishId;
	private String ingredientCash;

	public String getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(String ingredientId) {
		this.ingredientId = ingredientId;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getDishId() {
		return dishId;
	}

	public void setDishId(String dishId) {
		this.dishId = dishId;
	}

	public String getIngredientCash() {
		return ingredientCash;
	}

	public void setIngredientCash(String ingredientCash) {
		this.ingredientCash = ingredientCash;
	}
}
