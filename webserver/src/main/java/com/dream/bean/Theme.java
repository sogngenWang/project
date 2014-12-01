package com.dream.bean;

import com.dream.basebean.PageBase;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Theme extends PageBase {

	// ************
	private Integer commentcount;

	private Integer userid;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getCommentcount() {
		return commentcount;
	}

	public void setCommentcount(Integer commentcount) {
		this.commentcount = commentcount;
	}

	private Integer themeid;

	private String themename;

	private Integer activityid;

	public Integer getThemeid() {
		return themeid;
	}

	public void setThemeid(Integer themeid) {
		this.themeid = themeid;
	}

	public String getThemename() {
		return themename;
	}

	public void setThemename(String themename) {
		this.themename = themename == null ? null : themename.trim();
	}

	public Integer getActivityid() {
		return activityid;
	}

	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}
}