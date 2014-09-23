package com.dream.service;

import java.util.List;

import com.dream.bean.Store;

public interface StoreService {

	Store detailStore(Store store);

	List<Store> listStore(Store store);

	int updateStore(Store store);

	int addStore(Store store);

	int deleteStore(int storeid);
}
