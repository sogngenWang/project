package com.dream.weddingexpo.dao;

import java.util.List;

import com.dream.weddingexpo.bean.Message;

public interface MessageDao {
	List<Message> messageList(Message message);

	Message detailMessage(Message message);

	void addMessage(Message message);

	void deleteMessage(Message message);

	Message updateMessage(Message message);

	List<Message> listMessageStoreIdNotNull(Message message);
}
