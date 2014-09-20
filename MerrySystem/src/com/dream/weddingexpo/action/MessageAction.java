package com.dream.weddingexpo.action;

import java.util.List;

import com.dream.weddingexpo.bean.Message;
import com.dream.weddingexpo.constant.Constants;
import com.dream.weddingexpo.service.MessageService;
import com.opensymphony.xwork2.ActionSupport;

public class MessageAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Message message;
	private MessageService messageService;
	private String passwd;

	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public MessageService getMessageService() {
		return messageService;
	}
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
	/**
	 * 根据传入的meesageId获取messge详情
	 * @param message
	 * @return
	 */
	public String detailMessage(){
		message = messageService.detailMessage(message);
		//如果该新闻使用图片了
		return SUCCESS;
	}
	

	/**
	 * 根据传入的商家id，获取该商家的商品信息/新闻信息
	 */
	public String listMessage() {
 		List<Message> messageList = messageService.listMessage(message);
		if (null != messageList) {
			// 返回结果集
			message.setMessageList(messageList);
		}
		return SUCCESS;
	}
	/**
	 * 添加新闻
	 * 
	 */
	public String addMessage(){
		if(!(Constants.PASSWD).equals(passwd)){
			message.setMessageInfo("密码错误，添加失败");
			return SUCCESS;
		}
		
		try {
			messageService.addMessage(message);
			message.setMessageInfo("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 首页
	 */
	public String firstPage(){
		
 		List<Message> messageList = messageService.listMessageStoreIdNotNull(message);
		if (null != messageList) {
			// 返回结果集
			message.setMessageList(messageList);
		}
		
		return SUCCESS;
	}
	
	public String listMessageNoContent(){
 		List<Message> messageList = messageService.listMessageNoContent(message);
		if (null != messageList) {
			// 返回结果集
			message.setMessageList(messageList);
		}
		return SUCCESS;
	}
	
	public String updateMessage(){
		message = messageService.updateMessage(message);
		return SUCCESS;
	}
	

	
}
