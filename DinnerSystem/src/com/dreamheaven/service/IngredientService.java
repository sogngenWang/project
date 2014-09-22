package com.dreamheaven.service;

import java.util.List;

import com.dreamheaven.domain.Ingredient;

public interface IngredientService {

	Ingredient detailIngredient(Ingredient ingredient);

	boolean createIngredient(Ingredient ingredient);

	boolean deleteIngredient(Ingredient ingredient);

	boolean updateIngredient(Ingredient ingredient);

	List<Ingredient> queryAllIngredients(Ingredient ingredient);

}
