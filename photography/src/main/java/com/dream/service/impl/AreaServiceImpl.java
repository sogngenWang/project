package com.dream.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.dream.bean.Area;
import com.dream.dao.AreaDao;
import com.dream.service.AreaService;

@Repository(value = "areaService")
public class AreaServiceImpl implements AreaService {

	@Resource(name = "areaDao")
	private AreaDao areaDao;

	@Override
	public Area detailArea(Area area) {
		return areaDao.detailArea(area);
	}

	@Override
	public List<Area> listArea(Area area) {
		return areaDao.listArea(area);
	}

	@Override
	public Area updateArea(Area area) {
		return areaDao.updateArea(area);
	}

	@Override
	public void addArea(Area area) {
		areaDao.addArea(area);
	}

	@Override
	public void deleteArea(Area area) {
		areaDao.deleteArea(area);
	}

}
