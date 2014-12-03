package com.dream.weddingexpo.bean;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Top {

	private String topId;

	private String messageId;

	public String getTopId() {
		return topId;
	}

	public void setTopId(String topId) {
		this.topId = topId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Override
	public String toString() {
		return "Top [topId=" + topId + ", messageId=" + messageId + "]";
	}

}
