package com.dream.weddingexpo.bean;

import java.util.ArrayList;
import java.util.List;

public class Kinds {
	/**
	 * 分类id
	 */
	public String kindsId;
	/**
	 * 分类名字
	 */
	public String kindsName;
	/**
	 * 分类下包含的storeId————由多个名字组成，中间用逗号隔开
	 */
	public String kindsStore;

	// *************************

	public List<Store> kindsStoreList = new ArrayList<Store>();
	
	public List<Kinds> kindsList = new ArrayList<Kinds>();

	public List<Kinds> getKindsList() {
		return kindsList;
	}

	public void setKindsList(List<Kinds> kindsList) {
		this.kindsList = kindsList;
	}

	public String getKindsId() {
		return kindsId;
	}

	public void setKindsId(String kindsId) {
		this.kindsId = kindsId;
	}

	public String getKindsName() {
		return kindsName;
	}

	public void setKindsName(String kindsName) {
		this.kindsName = kindsName;
	}

	public String getKindsStore() {
		return kindsStore;
	}

	public void setKindsStore(String kindsStore) {
		this.kindsStore = kindsStore;
	}

	public List<Store> getKindsStoreList() {
		return kindsStoreList;
	}

	public void setKindsStoreList(List<Store> kindsStoreList) {
		this.kindsStoreList = kindsStoreList;
	}

}
