package com.dream.dao;

import java.util.List;

import com.dream.bean.Store;

public interface StoreDao {
	
	Store detailStore(Store store);

	List<Store> listStore(Store store);

	Store updateStore(Store store);

	void addStore(Store store);

	void deleteStore(Store store);
}
