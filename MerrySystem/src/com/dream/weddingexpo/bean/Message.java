package com.dream.weddingexpo.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Message {
	// 信息id
	private String messageId;
	// 信息标题
	private String messageTitle;
	// 新闻存放路径
	private String messageContentPath;

	private String userId;

	private String createTime;

	private String lastUpdateTime;

	// ********************************
	// 信息正文
	private String messageContent;
	// 回显信息
	private String messageInfo;
	// 置顶标志
	private String isTop;
	//操作人员用户名
	private String username;
	//操作人员密码
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private List<Message> messageList = new ArrayList<Message>();

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public String getMessageInfo() {
		return messageInfo;
	}

	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
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

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", messageTitle="
				+ messageTitle + ", messageContentPath=" + messageContentPath
				+ ", userId=" + userId + ", createTime=" + createTime
				+ ", lastUpdateTime=" + lastUpdateTime + ", messageContent="
				+ messageContent + ", messageInfo=" + messageInfo + ", isTop="
				+ isTop + ", username=" + username + ", password=" + password
				+ ", messageList=" + messageList + "]";
	}
	
}
