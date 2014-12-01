package com.dream.bean;

import com.dream.basebean.PageBase;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Message extends PageBase {

	// *************
//	private String username;
//
//	private String company;
//
//	private String position;
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getCompany() {
//		return company;
//	}
//
//	public void setCompany(String company) {
//		this.company = company;
//	}
//
//	public String getPosition() {
//		return position;
//	}
//
//	public void setPosition(String position) {
//		this.position = position;
//	}

	private Integer messageid;

	private Integer userid;

	private String isread;

	private String messagedate;

	private String messagecontent;

	public Integer getMessageid() {
		return messageid;
	}

	public void setMessageid(Integer messageid) {
		this.messageid = messageid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getIsread() {
		return isread;
	}

	public void setIsread(String isread) {
		this.isread = isread == null ? null : isread.trim();
	}

	public String getMessagedate() {
		return messagedate;
	}

	public void setMessagedate(String messagedate) {
		this.messagedate = messagedate == null ? null : messagedate.trim();
	}

	public String getMessagecontent() {
		return messagecontent;
	}

	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent == null ? null : messagecontent
				.trim();
	}
}