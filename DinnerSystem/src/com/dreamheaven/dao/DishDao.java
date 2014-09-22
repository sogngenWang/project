package com.dreamheaven.dao;

import java.util.List;

import com.dreamheaven.domain.Dish;



public interface DishDao {

	int countDish(Dish dish);

	void deleteDish(Dish dish);

	void createDish(Dish dish);
	
	void updateDish(Dish dish);
	
	Dish detailDish(Dish dish);
	
	List<Dish> queryDish(Dish dish) ;
	
	
}
