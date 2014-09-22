package com.dreamheaven.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.dreamheaven.dao.DishDao;
import com.dreamheaven.domain.Dish;
import com.dreamheaven.service.DishService;

public class DishServiceImpl implements DishService{

	private static Logger logger = Logger.getLogger(DishServiceImpl.class);
	
	public DishDao dishDao;

	public DishDao getDishDao() {
		return dishDao;
	}

	public void setDishDao(DishDao dishDao) {
		this.dishDao = dishDao;
	}

	public boolean createDish(Dish dish) {
		dishDao.createDish(dish);
		return false;
	}

	public boolean deleteDish(Dish dish) {
		dishDao.deleteDish(dish);
		return false;
	}

	public Dish detailDish(Dish dish) {
		return dishDao.detailDish(dish);
	}

	public List<Dish> queryAllDishs(Dish dish) {
		
		return dishDao.queryDish(dish);
	}

	public boolean updateDish(Dish dish) {
		dishDao.updateDish(dish);
		return false;
	}
	
	

}
