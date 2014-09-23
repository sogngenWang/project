package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Commodity;
import com.dream.dao.CommodityMapper;
import com.dream.service.CommodityService;

@Repository(value = "commodityService")
public class CommodityServiceImpl implements CommodityService {
	
	@Autowired
	private CommodityMapper commodityDao;

	@Override
	public Commodity detailCommodity(Commodity commodity) {
		return commodityDao.detailCommodity(commodity);
	}

	@Override
	public List<Commodity> listCommodity(Commodity commodity) {
		return commodityDao.listCommodity(commodity);
	}

	@Override
	public int updateCommodity(Commodity commodity) {
		return commodityDao.updateByPrimaryKeySelective(commodity);
	}

	@Override
	public int addCommodity(Commodity commodity) {
		return commodityDao.insert(commodity);
	}

	@Override
	public int deleteCommodity(int commodityid) {
		return commodityDao.deleteByPrimaryKey(commodityid);
	}

}
