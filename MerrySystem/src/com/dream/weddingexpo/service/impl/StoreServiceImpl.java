package com.dream.weddingexpo.service.impl;

import java.util.List;

import com.dream.weddingexpo.bean.Store;
import com.dream.weddingexpo.dao.StoreDao;
import com.dream.weddingexpo.service.StoreService;

public class StoreServiceImpl implements StoreService {

	private StoreDao storeDao;

	public StoreDao getStoreDao() {
		return storeDao;
	}

	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
	}

	@Override
	public List<Store> listStore(Store store) {
		return storeDao.storeList(store);
	}

	@Override
	public void addStore(Store store) {
		storeDao.addStore(store);
	}

	@Override
	public Store deatilStore(Store store) {
		return storeDao.detailStore(store);
	}

	@Override
	public void deleteStore(Store store) {
		storeDao.deleteStore(store);
	}

	@Override
	public Store updateStore(Store store) {
		return storeDao.updateStore(store);
	}

}
