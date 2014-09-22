package com.dreamheaven.at.domain;

import java.io.Serializable;

public class AtPK implements Serializable{
	
	private static final long serialVersionUID = -3981164134419118554L;

	private String mid;
	
	private String atUid;
	
	private String atType;
	
	private String seqNum;

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getAtUid() {
		return atUid;
	}

	public void setAtUid(String atUid) {
		this.atUid = atUid;
	}

	public String getAtType() {
		return atType;
	}

	public void setAtType(String atType) {
		this.atType = atType;
	}

	public String getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}
	
	
		
}
