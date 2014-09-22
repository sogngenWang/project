package com.dreamheaven.relymessage.domain;

import java.io.Serializable;

public class RelyMessagePK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 296815075848607920L;

	private String mid;
	
	private String relySeqNum;

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getRelySeqNum() {
		return relySeqNum;
	}

	public void setRelySeqNum(String relySeqNum) {
		this.relySeqNum = relySeqNum;
	}
	
}
