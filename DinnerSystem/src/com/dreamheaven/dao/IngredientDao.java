package com.dreamheaven.dao;

import java.util.List;

import com.dreamheaven.domain.Ingredient;



public interface IngredientDao {

	int countIngredient(Ingredient ingredient);

	void deleteIngredient(Ingredient ingredient);

	void createIngredient(Ingredient ingredient);
	
	void updateIngredient(Ingredient ingredient);
	
	Ingredient detailIngredient(Ingredient ingredient);
	
	List<Ingredient> queryIngredient(Ingredient ingredient) ;
	
	
}
