package com.dreamheaven.domain;

import java.io.Serializable;

public class UserTmp implements Serializable{

	private static final long serialVersionUID = -4010560864874830292L;
	private String uid;
	private String userSessionId;
	private String startTime;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

}
