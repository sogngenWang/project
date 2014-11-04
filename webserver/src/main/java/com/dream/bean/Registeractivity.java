package com.dream.bean;

import com.dream.basebean.PageBase;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Registeractivity extends PageBase{

	private Integer registrationid;

	private Integer userid;

	private Integer activityid;

	private Integer signstatus;

	//***************
	//活动报名总人数
	private Integer registercount;
	//活动签到总人数
	private Integer signcount;

	public Integer getRegistercount() {
		return registercount;
	}

	public void setRegistercount(Integer registercount) {
		this.registercount = registercount;
	}

	public Integer getSigncount() {
		return signcount;
	}

	public void setSigncount(Integer signcount) {
		this.signcount = signcount;
	}

	public Integer getRegistrationid() {
		return registrationid;
	}

	public void setRegistrationid(Integer registrationid) {
		this.registrationid = registrationid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getActivityid() {
		return activityid;
	}

	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}

	public Integer getSignstatus() {
		return signstatus;
	}

	public void setSignstatus(Integer signstatus) {
		this.signstatus = signstatus;
	}
}