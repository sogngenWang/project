package com.dream.bean;

import com.dream.basebean.PageBase;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Activity extends PageBase{
	
	
	//*****新增费数据库字段****
	//评论数
	private Integer commentCount;
	//点赞数
	private Integer praiseCount;
	//关注度
	private Integer caredegree;
	
	
	
    public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}

	public Integer getCaredegree() {
		return caredegree;
	}

	public void setCaredegree(Integer caredegree) {
		this.caredegree = caredegree;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activityid
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    private Integer activityid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activityname
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    private String activityname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activitystarttime
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    private String activitystarttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activityendtime
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    private String activityendtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activitystatus
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    private String activitystatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activityquota
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    private String activityquota;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activityaddress
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    private String activityaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activitycreatetime
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    private String activitycreatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.activitypicturedir
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    private String activitypicturedir;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.kindsid
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    private Integer kindsid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column activity.secondkindsid
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    private Integer secondkindsid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activityid
     *
     * @return the value of activity.activityid
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public Integer getActivityid() {
        return activityid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activityid
     *
     * @param activityid the value for activity.activityid
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activityname
     *
     * @return the value of activity.activityname
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public String getActivityname() {
        return activityname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activityname
     *
     * @param activityname the value for activity.activityname
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public void setActivityname(String activityname) {
        this.activityname = activityname == null ? null : activityname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activitystarttime
     *
     * @return the value of activity.activitystarttime
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public String getActivitystarttime() {
        return activitystarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activitystarttime
     *
     * @param activitystarttime the value for activity.activitystarttime
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public void setActivitystarttime(String activitystarttime) {
        this.activitystarttime = activitystarttime == null ? null : activitystarttime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activityendtime
     *
     * @return the value of activity.activityendtime
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public String getActivityendtime() {
        return activityendtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activityendtime
     *
     * @param activityendtime the value for activity.activityendtime
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public void setActivityendtime(String activityendtime) {
        this.activityendtime = activityendtime == null ? null : activityendtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activitystatus
     *
     * @return the value of activity.activitystatus
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public String getActivitystatus() {
        return activitystatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activitystatus
     *
     * @param activitystatus the value for activity.activitystatus
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public void setActivitystatus(String activitystatus) {
        this.activitystatus = activitystatus == null ? null : activitystatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activityquota
     *
     * @return the value of activity.activityquota
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public String getActivityquota() {
        return activityquota;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activityquota
     *
     * @param activityquota the value for activity.activityquota
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public void setActivityquota(String activityquota) {
        this.activityquota = activityquota == null ? null : activityquota.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activityaddress
     *
     * @return the value of activity.activityaddress
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public String getActivityaddress() {
        return activityaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activityaddress
     *
     * @param activityaddress the value for activity.activityaddress
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public void setActivityaddress(String activityaddress) {
        this.activityaddress = activityaddress == null ? null : activityaddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activitycreatetime
     *
     * @return the value of activity.activitycreatetime
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public String getActivitycreatetime() {
        return activitycreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activitycreatetime
     *
     * @param activitycreatetime the value for activity.activitycreatetime
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public void setActivitycreatetime(String activitycreatetime) {
        this.activitycreatetime = activitycreatetime == null ? null : activitycreatetime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.activitypicturedir
     *
     * @return the value of activity.activitypicturedir
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public String getActivitypicturedir() {
        return activitypicturedir;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.activitypicturedir
     *
     * @param activitypicturedir the value for activity.activitypicturedir
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public void setActivitypicturedir(String activitypicturedir) {
        this.activitypicturedir = activitypicturedir == null ? null : activitypicturedir.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.kindsid
     *
     * @return the value of activity.kindsid
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public Integer getKindsid() {
        return kindsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.kindsid
     *
     * @param kindsid the value for activity.kindsid
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public void setKindsid(Integer kindsid) {
        this.kindsid = kindsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column activity.secondkindsid
     *
     * @return the value of activity.secondkindsid
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public Integer getSecondkindsid() {
        return secondkindsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column activity.secondkindsid
     *
     * @param secondkindsid the value for activity.secondkindsid
     *
     * @mbggenerated Thu Oct 30 11:55:32 CST 2014
     */
    public void setSecondkindsid(Integer secondkindsid) {
        this.secondkindsid = secondkindsid;
    }
}