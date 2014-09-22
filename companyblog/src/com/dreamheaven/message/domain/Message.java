package com.dreamheaven.message.domain;

import java.util.ArrayList;
import java.util.List;

import com.dreamheaven.relymessage.domain.RelyMessage;

public class Message {
	
	private String mid;
	
	private String uid;
	
	private String mcontent;
	
	private String createTime;
	
	//-------------------------
	
	private String relyFlag;
	
	private List<RelyMessage> relyMessageList = new ArrayList<RelyMessage>();

	private String nickName;

	private String headPath;
	
	private List<Message> messageList = new ArrayList<Message>();
	 
	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadPath() {
		return headPath;
	}

	public void setHeadPath(String headPath) {
		this.headPath = headPath;
	}

	public List<RelyMessage> getRelyMessageList() {
		return relyMessageList;
	}

	public void setRelyMessageList(List<RelyMessage> relyMessageList) {
		this.relyMessageList = relyMessageList;
	}

	public String getRelyFlag() {
		return relyFlag;
	}

	public void setRelyFlag(String relyFlag) {
		this.relyFlag = relyFlag;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	
}
