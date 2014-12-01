package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Message;
import com.dream.constants.Constant;
import com.dream.dao.MessageMapper;
import com.dream.service.MessageService;

@Repository(value = "messageService")
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageMapper messageDao;
	
//	@Autowired
//	private UserMapper userDao ;
	

	@Override
	public List<Message> listMessage(Message message) {

		return messageDao.listMessage(message);
	}

	@Override
	public Message detailMessage(Message message) {

		return messageDao.detailMessage(message);
	}

	@Override
	public int updateMessage(Message message) {

		return messageDao.updateByPrimaryKeySelective(message);
	}

	@Override
	public int deleteMessage(int uid) {

		return messageDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addMessage(Message message) {

		return messageDao.insert(message);

	}

	@Override
	public int countMessage(Message message) {

		return messageDao.countMessage(message);
	}

	@Override
	public Message detailAndSetreadMessage(Message message) {
		//读取单条记录
		message = messageDao.detailMessage(message);
		//更新字段值
		message.setIsread(Constant.MESSAGE_READ_FLAG);
		messageDao.updateByPrimaryKey(message);
		
		return message;
	}

	@Override
	public List<Message> listRoughMessage(Message message) {
		//先查出所有的消息
		List<Message> messageList = messageDao.listRoughMessage(message);
//		//遍历消息
//		for (Message messageTmp : messageList) {
//			Integer userid = messageTmp.getUserid();
//			User user = new User();
//			user.setUserid(userid);
//			user = userDao.detailUser2Friends(user);
//			messageTmp.setUsername(user.getUsername());
//		}
//		
		return messageList;
	}

}
