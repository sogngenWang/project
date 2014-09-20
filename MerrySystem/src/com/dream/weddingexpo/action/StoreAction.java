package com.dream.weddingexpo.action;

import java.util.List;

import com.dream.weddingexpo.bean.Store;
import com.dream.weddingexpo.service.StoreService;
import com.opensymphony.xwork2.ActionSupport;

public class StoreAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Store store;
	private StoreService storeService;

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public StoreService getStoreService() {
		return storeService;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	/**
	 * 获取所有的商家信息
	 * 
	 * @return
	 */
	public String getStoreList() {
		List<Store> storeList = storeService.listStore(store);
		if (null != storeList) {
			// 返回结果集
			store.setStoreList(storeList);
		}
		return SUCCESS;
	}

}
