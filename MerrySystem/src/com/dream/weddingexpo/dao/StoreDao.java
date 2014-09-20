package com.dream.weddingexpo.dao;

import java.util.List;

import com.dream.weddingexpo.bean.Store;

public interface StoreDao {

	List<Store> storeList(Store store);

	Store detailStore(Store store);

	void addStore(Store store);

	void deleteStore(Store store);

	Store updateStore(Store store);
}
