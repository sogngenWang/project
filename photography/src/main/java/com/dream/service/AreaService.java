package com.dream.service;

import java.util.List;

import com.dream.bean.Area;

public interface AreaService {

	Area detailArea(Area area);

	List<Area> listArea(Area area);

	int updateArea(Area area);

	int addArea(Area area);

	int deleteArea(int areaid);
}
