package com.dream.weddingexpo.service;

import java.util.List;

import com.dream.weddingexpo.bean.Message;

public interface MessageService {

	Message detailMessage(Message message);

	List<Message> listMessage(Message message);

	void addMessage(Message message) ;
	
	List<Message> listMessageNoContent(Message message);
	
	void deleteMessage(Message message);

	Message updateMessage(Message message);

	List<Message> listMessageStoreIdNotNull(Message message);
}
