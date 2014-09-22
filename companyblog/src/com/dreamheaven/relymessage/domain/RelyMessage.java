package com.dreamheaven.relymessage.domain;

public class RelyMessage {
	

	private RelyMessagePK relyMessagePK = new RelyMessagePK();
	
	private String uid;
	
	private String relyContent;
	
	private String relyTime;
	
	//---------------------
	
	private String relyUserNickName;
	
	private String relyUserPath;
	
	

	public String getRelyUserPath() {
		return relyUserPath;
	}

	public void setRelyUserPath(String relyUserPath) {
		this.relyUserPath = relyUserPath;
	}

	public String getRelyUserNickName() {
		return relyUserNickName;
	}

	public void setRelyUserNickName(String relyUserNickName) {
		this.relyUserNickName = relyUserNickName;
	}

	public RelyMessagePK getRelyMessagePK() {
		return relyMessagePK;
	}

	public void setRelyMessagePK(RelyMessagePK relyMessagePK) {
		this.relyMessagePK = relyMessagePK;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRelyContent() {
		return relyContent;
	}

	public void setRelyContent(String relyContent) {
		this.relyContent = relyContent;
	}

	public String getRelyTime() {
		return relyTime;
	}

	public void setRelyTime(String relyTime) {
		this.relyTime = relyTime;
	}


}
