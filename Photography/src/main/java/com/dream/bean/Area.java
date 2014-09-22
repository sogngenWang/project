package com.dream.bean;

import org.springframework.stereotype.Repository;

@Repository(value = "area")
public class Area {

	private String areaId;

	private String areaName;

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}
