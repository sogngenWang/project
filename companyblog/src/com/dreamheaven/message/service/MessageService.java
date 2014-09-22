package com.dreamheaven.message.service;

import java.util.List;

import com.dreamheaven.message.domain.Message;

public interface MessageService {

	List<Message> queryMessage(Message message);
	
	void createMessage(Message message);
	
	int countMessage(Message message);
	
	void deleteMessage(Message message);
}
