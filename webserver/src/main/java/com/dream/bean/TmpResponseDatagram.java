package com.dream.bean;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonInclude(Include.NON_NULL)
public class TmpResponseDatagram {

	private TmpMsgResponse msg;

	private Object content;

	private String mac;
	
	private Map<String,String> contentMap = new HashMap<String,String>();
	
	public TmpResponseDatagram() {
		contentMap.put("username1", "heh");
		contentMap.put("username2", "heh");
	}

	public Map<String, String> getContentMap() {
		return contentMap;
	}

	public void setContentMap(Map<String, String> contentMap) {
		this.contentMap = contentMap;
	}

	public TmpMsgResponse getMsg() {
		return msg;
	}

	public void setMsg(TmpMsgResponse msg) {
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
