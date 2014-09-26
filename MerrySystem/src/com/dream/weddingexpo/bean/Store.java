package com.dream.weddingexpo.bean;

import java.util.ArrayList;

import java.util.List;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Store {
	// 商家id
	private String storeId;
	// 商家名字
	private String storeName;
	// 商家地址
	private String storeAddress;
	// 商家在会展现场的位置坐标
	private String storePosition;
	// ********************************
	private List<Store> storeList = new ArrayList<Store>();

	private String storeInfo;

	public String getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(String storeInfo) {
		this.storeInfo = storeInfo;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public List<Store> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStorePosition() {
		return storePosition;
	}

	public void setStorePosition(String storePosition) {
		this.storePosition = storePosition;
	}

}
