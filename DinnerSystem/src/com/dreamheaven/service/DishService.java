package com.dreamheaven.service;

import java.util.List;

import com.dreamheaven.domain.Dish;

public interface DishService {

	Dish detailDish(Dish dish);

	boolean createDish(Dish dish);

	boolean deleteDish(Dish dish);

	boolean updateDish(Dish dish);

	List<Dish> queryAllDishs(Dish dish);

}
