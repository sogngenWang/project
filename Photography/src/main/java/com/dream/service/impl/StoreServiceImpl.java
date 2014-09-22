package com.dream.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.dream.bean.Store;
import com.dream.dao.StoreDao;
import com.dream.service.StoreService;

@Repository(value = "storeService")
public class StoreServiceImpl implements StoreService {

	@Resource(name = "storeDao")
	private StoreDao storeDao;

	@Override
	public Store detailStore(Store store) {
		return storeDao.detailStore(store);
	}

	@Override
	public List<Store> listStore(Store store) {
		return storeDao.listStore(store);
	}

	@Override
	public Store updateStore(Store store) {
		return storeDao.updateStore(store);
	}

	@Override
	public void addStore(Store store) {
		storeDao.addStore(store);
	}

	@Override
	public void deleteStore(Store store) {
		storeDao.deleteStore(store);
	}

}
