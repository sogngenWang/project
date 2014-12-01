package com.dream.service;

import java.util.List;

import com.dream.bean.Message;

public interface MessageService {

	List<Message> listMessage(Message message);
	
	Message detailMessage(Message message);

	int updateMessage(Message message);
	
	int deleteMessage(int uid);
	
	int addMessage(Message message);
	
	int countMessage(Message message);

	Message detailAndSetreadMessage(Message message);

	List<Message> listRoughMessage(Message message);

}
