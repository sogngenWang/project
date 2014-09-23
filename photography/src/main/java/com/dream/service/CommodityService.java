package com.dream.service;

import java.util.List;

import com.dream.bean.Commodity;

public interface CommodityService {

	Commodity detailCommodity(Commodity commodity);

	List<Commodity> listCommodity(Commodity commodity);

	Commodity updateCommodity(Commodity commodity);

	void addCommodity(Commodity commodity);

	void deleteCommodity(Commodity commodity);
}
