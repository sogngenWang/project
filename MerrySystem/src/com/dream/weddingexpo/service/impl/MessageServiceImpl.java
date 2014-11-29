package com.dream.weddingexpo.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.dream.weddingexpo.bean.Message;
import com.dream.weddingexpo.constant.Constants;
import com.dream.weddingexpo.dao.MessageDao;
import com.dream.weddingexpo.service.MessageService;

public class MessageServiceImpl implements MessageService {
	
	private MessageDao messageDao;
	
	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public void addMessage(Message message){
		
		System.out.println(message.getMessageTitle()+"|+");
		System.out.println(message.getMessageContent()+"|");
		//写入到文件中，然后把文件路径写入到数据库中
		String path = Constants.IMG_PATH_PRE+System.currentTimeMillis();
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(new File(path)));
			writer.write(message.getMessageContent());
			writer.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(null != writer){
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		message.setMessageContentPath(path);
		
		messageDao.addMessage(message);
	}

	@Override
	public List<Message> listMessage(Message message) {
		List<Message> messageList = messageDao.messageList(message);
		
		for (Message messageTmp : messageList) {
			String path = messageTmp.getMessageContentPath();
			BufferedReader reader = null;
			StringBuffer sb = new StringBuffer();
			try {
				reader = new BufferedReader(new FileReader(new File(path)));
				String temp = reader.readLine();
				while(null != temp){
					sb.append(temp);
					temp = reader.readLine();
				}
				messageTmp.setMessageContent(sb.toString());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(null != reader){
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return messageList;
	}

	@Override
	public Message detailMessage(Message message) {
		message = messageDao.detailMessage(message);
		String path = message.getMessageContentPath();
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
		try {
			reader = new BufferedReader(new FileReader(new File(path)));
			String temp = reader.readLine();
			while(null != temp){
				sb.append(temp);
				temp = reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != reader){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		message.setMessageContent(sb.toString());
		
		return message;
	}

	@Override
	public List<Message> listMessageNoContent(Message message) {
		List<Message> messageList = messageDao.messageList(message);
		return messageList;
	}

	@Override
	public void deleteMessage(Message message) {
		messageDao.deleteMessage(message);
	}

	@Override
	public Message updateMessage(Message message) {
		
		return messageDao.updateMessage(message);
	}


	
	

}
