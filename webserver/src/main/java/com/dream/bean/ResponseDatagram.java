package com.dream.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonInclude(Include.NON_NULL)
public class ResponseDatagram {

	private MsgResponse msg;

	private Object content;

	private String mac;

	public MsgResponse getMsg() {
		return msg;
	}

	public void setMsg(MsgResponse msg) {
		this.msg = msg;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

}
