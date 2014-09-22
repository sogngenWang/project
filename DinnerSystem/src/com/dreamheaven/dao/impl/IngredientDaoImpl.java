package com.dreamheaven.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.dreamheaven.constant.Constant;
import com.dreamheaven.dao.IngredientDao;
import com.dreamheaven.domain.Ingredient;
import com.dreamheaven.domain.User;
import com.dreamheaven.hibernate.HibernateSessionFactory;
import com.dreamheaven.utils.CommonUtils;

public class IngredientDaoImpl implements IngredientDao {

	private Session session;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public IngredientDaoImpl() {
		session = HibernateSessionFactory.getSession();
	}

	private Map<String, String> getParamMap(Ingredient ingredient) {
		paramMap.put(Constant.ingredientId, ingredient.getIngredientId());
		paramMap.put(Constant.ingredientName, ingredient.getIngredientName());
		paramMap.put(Constant.dishId, ingredient.getDishId());
		paramMap.put(Constant.ingredientCash, ingredient.getIngredientCash());
		return paramMap;
	}

	public void createIngredient(Ingredient ingredient) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		ingredient = (Ingredient) session.merge(ingredient);
		session.save(ingredient);
		transaction.commit();

	}

	@SuppressWarnings("unchecked")
	public List<Ingredient> queryIngredient(Ingredient ingredient) {

		Criteria criteria = session.createCriteria(ingredient.getClass());

		CommonUtils.setCriteria(getParamMap(ingredient), criteria);

		return criteria.list();
	}

	public Ingredient detailIngredient(Ingredient ingredient) {
		Criteria criteria = session.createCriteria(ingredient.getClass());
		CommonUtils.setCriteria(getParamMap(ingredient), criteria);

		if (null != criteria.list()) {
			if(criteria.list().size() > 0){
				return (Ingredient) criteria.list().get(0);
			}
		}
		return null;
	}

	public int countIngredient(Ingredient ingredient) {
		Criteria criteria = session.createCriteria(ingredient.getClass());

		criteria.setProjection(Projections.rowCount());

		CommonUtils.setCriteria(getParamMap(ingredient), criteria);

		return ((Number) criteria.uniqueResult()).intValue();
	}

	public void deleteIngredient(Ingredient ingredient) {

		Transaction transaction = session.beginTransaction();
		transaction.begin();
		ingredient = (Ingredient) session.merge(ingredient);
		session.delete(ingredient);
		transaction.commit();

	}

	public void updateIngredient(Ingredient ingredient) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		ingredient = (Ingredient) session.merge(ingredient);
		session.save(ingredient);
		transaction.commit();
	}

}
