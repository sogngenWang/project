package com.dream.weddingexpo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dream.weddingexpo.bean.Kinds;
import com.dream.weddingexpo.bean.Store;
import com.dream.weddingexpo.dao.KindsDao;
import com.dream.weddingexpo.dao.StoreDao;
import com.dream.weddingexpo.service.KindsService;

public class KindsServiceImpl implements KindsService {
	
	private KindsDao kindsDao;
	private StoreDao storeDao;
	
	public StoreDao getStoreDao() {
		return storeDao;
	}

	public void setStoreDao(StoreDao storeDao) {
		this.storeDao = storeDao;
	}

	public KindsDao getKindsDao() {
		return kindsDao;
	}

	public void setKindsDao(KindsDao kindsDao) {
		this.kindsDao = kindsDao;
	}

	@Override
	public List<Kinds> listKinds(Kinds kinds) {

		return kindsDao.kindsList(kinds);
	}

	@Override
	public List<Store> listStoreByKindsStore(String kindsStore) {

		
		Map<String, Store> storeMap = new HashMap<String, Store>();
		Store store = new Store();
		//获取表中所有的store
		List<Store> storeList = storeDao.storeList(store);
		for (Store storetemp : storeList) {
			storeMap.put(storetemp.getStoreId(), storetemp);
		}
		List<Store> storeListTmp = new ArrayList<Store>();
		String[] kindsArray = kindsStore.split(";");
		// 改成批量查询
		for (String storeId : kindsArray) {
			Store storeTmp = storeMap.get(storeId);
			if (null != storeTmp) {
				storeListTmp.add(storeTmp);
			} else {
				System.out.println("Id 为空 ... id：" + storeId);
			}
		}

		return storeListTmp;
	}

	@Override
	public void addKinds(Kinds kinds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKinds(Kinds kinds) {
		kindsDao.deleteKinds(kinds);
	}

	@Override
	public Kinds detailKinds(Kinds kinds) {
		return kindsDao.detailKinds(kinds);
	}

	@Override
	public Kinds updateKinds(Kinds kinds) {
		return kindsDao.updateKinds(kinds);
	}

}
