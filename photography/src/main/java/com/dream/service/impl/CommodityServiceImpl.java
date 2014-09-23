package com.dream.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.dream.bean.Commodity;
import com.dream.dao.CommodityDao;
import com.dream.service.CommodityService;

@Repository(value = "commodityService")
public class CommodityServiceImpl implements CommodityService {
	
	@Resource(name = "commodityDao")
	private CommodityDao commodityDao;

	@Override
	public Commodity detailCommodity(Commodity commodity) {
		return commodityDao.detailCommodity(commodity);
	}

	@Override
	public List<Commodity> listCommodity(Commodity commodity) {
		return commodityDao.listCommodity(commodity);
	}

	@Override
	public Commodity updateCommodity(Commodity commodity) {
		return commodityDao.updateCommodity(commodity);
	}

	@Override
	public void addCommodity(Commodity commodity) {
		commodityDao.addCommodity(commodity);
	}

	@Override
	public void deleteCommodity(Commodity commodity) {
		commodityDao.deleteCommodity(commodity);
	}

}
