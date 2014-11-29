package com.dream.weddingexpo.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dream.weddingexpo.bean.Message;
import com.dream.weddingexpo.bean.Top;
import com.dream.weddingexpo.constant.Constants;
import com.dream.weddingexpo.dao.MessageDao;
import com.dream.weddingexpo.dao.TopDao;
import com.dream.weddingexpo.service.MessageService;

public class MessageServiceImpl implements MessageService {


	private MessageDao messageDao;

	private TopDao topDao;
	
	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public TopDao getTopDao() {
		return topDao;
	}

	public void setTopDao(TopDao topDao) {
		this.topDao = topDao;
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
			messageTmp.setMessageContent(null);
			messageTmp.setMessageContentPath(null);
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

	@Override
	public List<Message> listMessageInclueTop(Message message) {
		List<Message> messageList = messageDao.messageListOrderByTime(message);
		List<Message> returnMessageList = new ArrayList<Message>();
		//获取置顶列表
		Top top = new Top();
		List<Top> topList = topDao.topList(top);
		Map<String,String> topMap = new HashMap<String,String>();
		for (Top topTmp : topList) {
			topMap.put(topTmp.getMessageId(), topTmp.getTopId());
			//每个都需要占一个位置
			returnMessageList.add(null);
		}
		
		for (int i = 0; i < messageList.size() ; i++) {
			Message messageTmp = messageList.get(i);
			messageTmp.setMessageContent(null);
			messageTmp.setMessageContentPath(null);
			String index = topMap.get(messageTmp.getMessageId());
			if(null == index){
				returnMessageList.add(messageTmp);
			}else{
				messageTmp.setIsTop(Constants.ISTOP_TRUE_FLAG);
				returnMessageList.set(Integer.valueOf(index)-1, messageTmp);
			}
		}
		
		return returnMessageList;
	}


	
	

}
