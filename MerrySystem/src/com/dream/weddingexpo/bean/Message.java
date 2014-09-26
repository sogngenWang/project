package com.dream.weddingexpo.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Message {
	// 信息id
	private String messageId;
	// 商家id
	private String storeId;
	// 信息标题
	private String messageTitle;
	// 新闻存放路径
	private String messageContentPath;

	// ********************************
	// 信息正文
	private String messageContent;
	//商家名字
	private String storeName;
	//回显信息
	private String messageInfo;
	
	private List<Message> messageList = new ArrayList<Message>();
	
	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getMessageContentPath() {
		return messageContentPath;
	}

	public void setMessageContentPath(String messageContentPath) {
		this.messageContentPath = messageContentPath;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}


}
