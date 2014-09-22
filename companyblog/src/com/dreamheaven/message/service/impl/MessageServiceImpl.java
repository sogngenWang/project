package com.dreamheaven.message.service.impl;

import java.util.List;

import com.dreamheaven.message.dao.MessageDao;
import com.dreamheaven.message.domain.Message;
import com.dreamheaven.message.service.MessageService;

public class MessageServiceImpl implements MessageService {

	private MessageDao messageDao;

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public List<Message> queryMessage(Message message) {
		return messageDao.queryMessage(message);
	}

	@Override
	public void createMessage(Message message) {
		messageDao.createMessage(message);

	}

	@Override
	public int countMessage(Message message) {
		return messageDao.countMessage(message);
	}

	@Override
	public void deleteMessage(Message message) {
		messageDao.deleteMessage(message);
		
	}

}
