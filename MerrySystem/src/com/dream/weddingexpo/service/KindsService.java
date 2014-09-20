package com.dream.weddingexpo.service;

import java.util.List;

import com.dream.weddingexpo.bean.Kinds;
import com.dream.weddingexpo.bean.Store;

public interface KindsService {

	List<Kinds> listKinds(Kinds kinds);

	List<Store> listStoreByKindsStore(String kindsStore);
	
	void deleteKinds(Kinds kinds);
	
	Kinds detailKinds(Kinds kinds);

	Kinds updateKinds(Kinds kinds);
	
	void addKinds(Kinds kinds);
}
