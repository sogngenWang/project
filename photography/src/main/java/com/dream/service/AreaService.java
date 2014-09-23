package com.dream.service;

import java.util.List;

import com.dream.bean.Area;

public interface AreaService {

	Area detailArea(Area area);

	List<Area> listArea(Area area);

	Area updateArea(Area area);

	void addArea(Area area);

	void deleteArea(Area area);
}
