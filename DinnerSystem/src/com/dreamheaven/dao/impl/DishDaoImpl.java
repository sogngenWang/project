package com.dreamheaven.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.dreamheaven.constant.Constant;
import com.dreamheaven.dao.DishDao;
import com.dreamheaven.domain.Dish;
import com.dreamheaven.domain.User;
import com.dreamheaven.hibernate.HibernateSessionFactory;
import com.dreamheaven.utils.CommonUtils;

public class DishDaoImpl implements DishDao {

	private Session session;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public DishDaoImpl() {
		session = HibernateSessionFactory.getSession();
	}

	private Map<String, String> getParamMap(Dish dish) {
		paramMap.put(Constant.dishId, dish.getDishId());
		paramMap.put(Constant.dishName, dish.getDishName());
		paramMap.put(Constant.classId, dish.getClassId());
		paramMap.put(Constant.dishCash, dish.getDishCash());
		return paramMap;
	}

	public void createDish(Dish dish) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		dish = (Dish) session.merge(dish);
		session.save(dish);
		transaction.commit();

	}

	@SuppressWarnings("unchecked")
	public List<Dish> queryDish(Dish dish) {

		Criteria criteria = session.createCriteria(dish.getClass());

		CommonUtils.setCriteria(getParamMap(dish), criteria);

		return criteria.list();
	}

	public Dish detailDish(Dish dish) {
		Criteria criteria = session.createCriteria(dish.getClass());
		CommonUtils.setCriteria(getParamMap(dish), criteria);

		if (null != criteria.list()) {
			if(criteria.list().size() > 0){
				return (Dish) criteria.list().get(0);
			}
		}
		return null;
	}

	public int countDish(Dish dish) {
		Criteria criteria = session.createCriteria(dish.getClass());

		criteria.setProjection(Projections.rowCount());

		CommonUtils.setCriteria(getParamMap(dish), criteria);

		return ((Number) criteria.uniqueResult()).intValue();
	}

	public void deleteDish(Dish dish) {

		Transaction transaction = session.beginTransaction();
		transaction.begin();
		dish = (Dish) session.merge(dish);
		session.delete(dish);
		transaction.commit();

	}

	public void updateDish(Dish dish) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		dish = (Dish) session.merge(dish);
		session.save(dish);
		transaction.commit();
	}

}
