package com.dream.bean;

public class RequestDatagram {

	private HeadRequest head;

	private Object content;

	private String mac;

	public HeadRequest getHead() {
		return head;
	}

	public void setHead(HeadRequest head) {
		this.head = head;
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
