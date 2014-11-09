package com.dream.bean;

import com.dream.basebean.PageBase;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Friends extends PageBase {
	// ************************
	private String username;

	private String company;

	private String position;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	private Integer friendid;

	private Integer userid;

	private Integer frienduserid;

	private String isbefriend;

	private String accesstime;

	public Integer getFriendid() {
		return friendid;
	}

	public void setFriendid(Integer friendid) {
		this.friendid = friendid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getFrienduserid() {
		return frienduserid;
	}

	public void setFrienduserid(Integer frienduserid) {
		this.frienduserid = frienduserid;
	}

	public String getIsbefriend() {
		return isbefriend;
	}

	public void setIsbefriend(String isbefriend) {
		this.isbefriend = isbefriend == null ? null : isbefriend.trim();
	}

	public String getAccesstime() {
		return accesstime;
	}

	public void setAccesstime(String accesstime) {
		this.accesstime = accesstime == null ? null : accesstime.trim();
	}
}