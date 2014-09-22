package com.dream.bean;

import org.springframework.stereotype.Repository;

@Repository(value = "kinds")
public class Kinds {
	private String kindsId;

	private String kindsName;

	public String getKindsId() {
		return kindsId;
	}

	public void setKindsId(String kindsId) {
		this.kindsId = kindsId;
	}

	public String getKindsName() {
		return kindsName;
	}

	public void setKindsName(String kindsName) {
		this.kindsName = kindsName;
	}

}
