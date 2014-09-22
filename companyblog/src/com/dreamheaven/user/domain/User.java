package com.dreamheaven.user.domain;

import java.util.List;

import com.dreamheaven.common.domain.CommonSuper;
import com.dreamheaven.message.domain.Message;
import com.dreamheaven.relymessage.domain.RelyMessage;
import com.dreamheaven.userinfo.domain.UserInfo;

public class User extends CommonSuper {

	private String uid;
	
	private String userName;
	
	private String password;
	
	private String userType;
	
	private String active;

	//===========================================
	
	private List<UserInfo> userInfoList;
	
	private UserInfo userInfo;
	
	private List<Message> messageList;
	
	private String messageCount;
	
	private String fansCount;
	
	private String attentionCount;
	
	private String messageId;
	
	private List<RelyMessage> relyMessageList;
	
	private List<UserInfo> fansInfoList;
	
	private List<UserInfo> attentionInfoList;


	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public List<UserInfo> getFansInfoList() {
		return fansInfoList;
	}

	public void setFansInfoList(List<UserInfo> fansInfoList) {
		this.fansInfoList = fansInfoList;
	}

	public List<UserInfo> getAttentionInfoList() {
		return attentionInfoList;
	}

	public void setAttentionInfoList(List<UserInfo> attentionInfoList) {
		this.attentionInfoList = attentionInfoList;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public List<RelyMessage> getRelyMessageList() {
		return relyMessageList;
	}

	public void setRelyMessageList(List<RelyMessage> relyMessageList) {
		this.relyMessageList = relyMessageList;
	}

	public String getFansCount() {
		return fansCount;
	}

	public void setFansCount(String fansCount) {
		this.fansCount = fansCount;
	}

	public String getAttentionCount() {
		return attentionCount;
	}

	public void setAttentionCount(String attentionCount) {
		this.attentionCount = attentionCount;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	public String getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(String messageCount) {
		this.messageCount = messageCount;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
