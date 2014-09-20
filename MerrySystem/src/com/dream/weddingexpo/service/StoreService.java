package com.dream.weddingexpo.service;

import java.util.List;

import com.dream.weddingexpo.bean.Store;

public interface StoreService {

	List<Store> listStore(Store store);

	Store deatilStore(Store store);

	void addStore(Store store);

	void deleteStore(Store store);

	Store updateStore(Store store);

}
