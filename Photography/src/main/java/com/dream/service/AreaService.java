package com.dream.service;

import java.util.List;

import com.dream.bean.Area;

public interface AreaService {

	Area detailArea(Area are);

	List<Area> listArea(Area are);

	Area updateArea(Area are);

	void addArea(Area are);

	void deleteArea(Area are);
}
