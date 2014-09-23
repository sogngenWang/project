package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Area;
import com.dream.dao.AreaMapper;
import com.dream.service.AreaService;

@Repository(value = "areaService")
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaMapper areaDao;

	@Override
	public Area detailArea(Area area) {
		
		return areaDao.detailArea(area);
	}

	@Override
	public List<Area> listArea(Area area) {
		return areaDao.listArea(area);
	}

	@Override
	public int updateArea(Area area) {
		return areaDao.updateByPrimaryKeySelective(area);
	}

	@Override
	public int addArea(Area area) {
		return areaDao.insert(area);
	}

	@Override
	public int deleteArea(int areaid) {
		return areaDao.deleteByPrimaryKey(areaid);
	}


}
