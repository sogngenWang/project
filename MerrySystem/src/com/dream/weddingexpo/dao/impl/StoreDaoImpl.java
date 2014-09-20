package com.dream.weddingexpo.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dream.weddingexpo.bean.Store;
import com.dream.weddingexpo.constant.Constants;
import com.dream.weddingexpo.dao.StoreDao;
import com.dream.weddingexpo.hibernate.HibernateSessionFactory;
import com.dream.weddingexpo.utils.CommonUtils;

public class StoreDaoImpl implements StoreDao{

	private Session session;
	private Criteria criteria;

	private Map<String, String> paramMap = new HashMap<String, String>();

	public StoreDaoImpl() {
		session = HibernateSessionFactory.getSession();
	}

	private Map<String, String> getStoreParamMap(Store store) {
		paramMap.put(Constants.STORE_STOREID, store.getStoreId());
		paramMap.put(Constants.STORE_STORENAME, store.getStoreName());
		paramMap.put(Constants.STORE_STOREADDRESS, store.getStoreAddress());
		paramMap.put(Constants.STORE_STOREPOSITION, store.getStorePosition());
		return paramMap;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Store> storeList(Store store) {
		criteria = session.createCriteria(store.getClass());
		CommonUtils.setCriteria(getStoreParamMap(store), criteria);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Store detailStore(Store store) {
		criteria = session.createCriteria(store.getClass());
		CommonUtils.setCriteria(getStoreParamMap(store), criteria);
		List<Store> storeList = criteria.list();
		if(null != storeList && !storeList.isEmpty()){
			return storeList.get(0);
		}
		return null;
	}

	@Override
	public void addStore(Store store) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		store = (Store)session.merge(store);
		session.save(store);
		transaction.commit();
	}

	@Override
	public void deleteStore(Store store) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		store = (Store)session.merge(store);
		session.delete(store);
		transaction.commit();
	}

	@Override
	public Store updateStore(Store store) {
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		store = (Store)session.merge(store);
		session.save(store);
		transaction.commit();
		return store;
	}

}
