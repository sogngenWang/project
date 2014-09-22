package com.dreamheaven.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.dreamheaven.dao.IngredientDao;
import com.dreamheaven.domain.Ingredient;
import com.dreamheaven.service.IngredientService;

public class IngredientServiceImpl implements IngredientService{

	private static Logger logger = Logger.getLogger(IngredientServiceImpl.class);
	
	public IngredientDao ingredientDao;

	public IngredientDao getIngredientDao() {
		return ingredientDao;
	}

	public void setIngredientDao(IngredientDao ingredientDao) {
		this.ingredientDao = ingredientDao;
	}

	public boolean createIngredient(Ingredient ingredient) {
		ingredientDao.createIngredient(ingredient);
		return false;
	}

	public boolean deleteIngredient(Ingredient ingredient) {
		ingredientDao.deleteIngredient(ingredient);
		return false;
	}

	public Ingredient detailIngredient(Ingredient ingredient) {
		return ingredientDao.detailIngredient(ingredient);
	}

	public List<Ingredient> queryAllIngredients(Ingredient ingredient) {
		
		return ingredientDao.queryIngredient(ingredient);
	}

	public boolean updateIngredient(Ingredient ingredient) {
		ingredientDao.updateIngredient(ingredient);
		return false;
	}
	


}
