package com.dream.bean;

import com.dream.basebean.PageBase;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Activity extends PageBase {

	// *****新增非数据库字段****
	// 评论数
	private Integer commentcount;
	// 点赞数
	private Integer praisecount;
	// 关注度
	private Integer caredegree;
	// 头像地址
	private String activitypicture;
	// 已报名人数
	private Integer registercount;
	// 用户id
	private Integer userid;
	// 用户是否已经点赞 (0.还未点赞 1.已点赞)
	private String isuserpraise;

	public String getIsuserpraise() {
		return isuserpraise;
	}

	public void setIsuserpraise(String isuserpraise) {
		this.isuserpraise = isuserpraise;
	}

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

	public Integer getPraisecount() {
		return praisecount;
	}

	public void setPraisecount(Integer praisecount) {
		this.praisecount = praisecount;
	}

	public Integer getCaredegree() {
		return caredegree;
	}

	public void setCaredegree(Integer caredegree) {
		this.caredegree = caredegree;
	}

	public String getActivitypicture() {
		return activitypicture;
	}

	public void setActivitypicture(String activitypicture) {
		this.activitypicture = activitypicture;
	}

	public Integer getRegistercount() {
		return registercount;
	}

	public void setRegistercount(Integer registercount) {
		this.registercount = registercount;
	}

	private Integer activityid;

	private String activityname;

	private String activitystarttime;

	private String activityendtime;

	private String activitystatus;

	private Integer activityquota;

	private String activityaddress;

	private String activitycreatetime;

	private String activitypicturedir;

	private Integer kindsid;

	private Integer secondkindsid;

	private String activityabout;

	private String activitydetail;

	private Integer viewcount;

	public Integer getActivityquota() {
		return activityquota;
	}

	public void setActivityquota(Integer activityquota) {
		this.activityquota = activityquota;
	}

	public Integer getViewcount() {
		return viewcount;
	}

	public void setViewcount(Integer viewcount) {
		this.viewcount = viewcount;
	}

	public String getActivityabout() {
		return activityabout;
	}

	public void setActivityabout(String activityabout) {
		this.activityabout = activityabout == null ? null : activityabout
				.trim();
	}

	public String getActivitydetail() {
		return activitydetail;
	}

	public void setActivitydetail(String activitydetail) {
		this.activitydetail = activitydetail == null ? null : activitydetail
				.trim();
	}

	public Integer getActivityid() {
		return activityid;
	}

	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}

	public String getActivityname() {
		return activityname;
	}

	public void setActivityname(String activityname) {
		this.activityname = activityname == null ? null : activityname.trim();
	}

	public String getActivitystarttime() {
		return activitystarttime;
	}

	public void setActivitystarttime(String activitystarttime) {
		this.activitystarttime = activitystarttime == null ? null
				: activitystarttime.trim();
	}

	public String getActivityendtime() {
		return activityendtime;
	}

	public void setActivityendtime(String activityendtime) {
		this.activityendtime = activityendtime == null ? null : activityendtime
				.trim();
	}

	public String getActivitystatus() {
		return activitystatus;
	}

	public void setActivitystatus(String activitystatus) {
		this.activitystatus = activitystatus == null ? null : activitystatus
				.trim();
	}

	public String getActivityaddress() {
		return activityaddress;
	}

	public void setActivityaddress(String activityaddress) {
		this.activityaddress = activityaddress == null ? null : activityaddress
				.trim();
	}

	public String getActivitycreatetime() {
		return activitycreatetime;
	}

	public void setActivitycreatetime(String activitycreatetime) {
		this.activitycreatetime = activitycreatetime == null ? null
				: activitycreatetime.trim();
	}

	public String getActivitypicturedir() {
		return activitypicturedir;
	}

	public void setActivitypicturedir(String activitypicturedir) {
		this.activitypicturedir = activitypicturedir == null ? null
				: activitypicturedir.trim();
	}

	public Integer getKindsid() {
		return kindsid;
	}

	public void setKindsid(Integer kindsid) {
		this.kindsid = kindsid;
	}

	public Integer getSecondkindsid() {
		return secondkindsid;
	}

	public void setSecondkindsid(Integer secondkindsid) {
		this.secondkindsid = secondkindsid;
	}
}