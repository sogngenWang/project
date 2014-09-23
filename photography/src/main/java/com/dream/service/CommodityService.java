package com.dream.service;

import java.util.List;

import com.dream.bean.Commodity;

public interface CommodityService {

	Commodity detailCommodity(Commodity commodity);

	List<Commodity> listCommodity(Commodity commodity);

	int updateCommodity(Commodity commodity);

	int addCommodity(Commodity commodity);

	int deleteCommodity(int commodityid);
}
