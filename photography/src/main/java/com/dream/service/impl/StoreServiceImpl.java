package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Store;
import com.dream.dao.StoreMapper;
import com.dream.service.StoreService;

@Repository(value = "storeService")
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreMapper storeDao;

	@Override
	public Store detailStore(Store store) {
		return storeDao.detailStore(store);
	}

	@Override
	public List<Store> listStore(Store store) {
		return storeDao.listStore(store);
	}

	@Override
	public int updateStore(Store store) {
		return storeDao.updateByPrimaryKeySelective(store);
	}

	@Override
	public int addStore(Store store) {
		return storeDao.insert(store);
	}

	@Override
	public int deleteStore(int storeid) {
		return storeDao.deleteByPrimaryKey(storeid);
	}




}
