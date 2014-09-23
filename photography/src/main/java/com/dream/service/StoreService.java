package com.dream.service;

import java.util.List;

import com.dream.bean.Store;

public interface StoreService {

	Store detailStore(Store store);

	List<Store> listStore(Store store);

	Store updateStore(Store store);

	void addStore(Store store);

	void deleteStore(Store store);
}
