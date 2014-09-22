package com.dreamheaven.at.domain;

import java.util.List;

import com.dreamheaven.message.domain.Message;
import com.dreamheaven.relymessage.domain.RelyMessage;

public class At {
	
	private AtPK atPK = new AtPK();
	
	//-------------------------
	
	private List<Message> atMeMessageList;
	
	private List<RelyMessage> atMeRelyMessageList;
	

	public List<Message> getAtMeMessageList() {
		return atMeMessageList;
	}

	public void setAtMeMessageList(List<Message> atMeMessageList) {
		this.atMeMessageList = atMeMessageList;
	}

	public List<RelyMessage> getAtMeRelyMessageList() {
		return atMeRelyMessageList;
	}

	public void setAtMeRelyMessageList(List<RelyMessage> atMeRelyMessageList) {
		this.atMeRelyMessageList = atMeRelyMessageList;
	}

	public AtPK getAtPK() {
		return atPK;
	}

	public void setAtPK(AtPK atPK) {
		this.atPK = atPK;
	}

}
