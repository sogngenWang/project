package com.dream.bean;

public class TmpRequestDatagram {

	private TmpHeadRequest head;

	private Object content;

	private String mac;

	public TmpHeadRequest getHead() {
		return head;
	}

	public void setHead(TmpHeadRequest head) {
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
