package com.dreamheaven.userinterest.domain;

import java.io.Serializable;

public class UserInterestPK implements Serializable{
	
	private static final long serialVersionUID = -490067277835330954L;

	private String uid;

	private String listenedId;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getListenedId() {
		return listenedId;
	}

	public void setListenedId(String listenedId) {
		this.listenedId = listenedId;
	}

}
