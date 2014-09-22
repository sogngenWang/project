package com.dreamheaven.message.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.dreamheaven.at.domain.At;
import com.dreamheaven.at.domain.AtPK;
import com.dreamheaven.at.service.AtService;
import com.dreamheaven.common.constant.CommonConstant;
import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.message.domain.Message;
import com.dreamheaven.message.service.MessageService;
import com.dreamheaven.relymessage.domain.RelyMessage;
import com.dreamheaven.relymessage.domain.RelyMessagePK;
import com.dreamheaven.relymessage.service.RelyMessageService;
import com.dreamheaven.user.domain.User;
import com.opensymphony.xwork2.ActionSupport;

public class MessageAction extends ActionSupport{
	
	private static final long serialVersionUID = 7283384020395274968L;
	
	private MessageService messageService;
	
	private RelyMessageService relyMessageService;
	
	private AtService atService ;
	
	private String messageText;
	
	private String messageId;
	
	private User user ;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RelyMessageService getRelyMessageService() {
		return relyMessageService;
	}

	public void setRelyMessageService(RelyMessageService relyMessageService) {
		this.relyMessageService = relyMessageService;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public AtService getAtService() {
		return atService;
	}

	public void setAtService(AtService atService) {
		this.atService = atService;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	@Override
	public String execute() throws Exception {

		return null;
	}
	
	
	public String countMessage()
	{
		try {

			Message message = new Message();
			//查询当前用户的message
			message.setUid(CommonUtils.getUserFromSession().getUid());
			int count = messageService.countMessage(message);

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html; charset=utf-8");
			JSONObject obj = new JSONObject();
			obj.put("weiboCount", count);
			obj.put("isSuccess", true);
			PrintWriter out = response.getWriter();
			out.println(obj);
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String createMessage()
	{
		User user = CommonUtils.getUserFromSession();
		
		Message message = new Message();
		message.setUid(user.getUid());
		message.setMcontent(messageText);
		message.setCreateTime(CommonUtils.getNowTime());
		
		Set<String> atUserSet = CommonUtils.generateAtAndMContent(message);
		
		messageService.createMessage(message);
		
		//把所有at到的人存到表里

		At at = new At();
		AtPK atPK = at.getAtPK();
		atPK.setMid(message.getMid());
		atPK.setSeqNum("0");
		atPK.setAtType("1");
		for(String uidTemp : atUserSet)
		{
			atPK.setAtUid(uidTemp);
			atService.createAt(at);
		}
		
		return SUCCESS;
	}
	
	public String deleteMessage()
	{
		//根据mid删除响应的微博以及评论
		Message message = new Message();
		message.setMid(messageId);
		messageService.deleteMessage(message);
		//删除评论
		RelyMessage relyMessage = new RelyMessage();
		RelyMessagePK relyMessagePK = new RelyMessagePK();
		relyMessagePK.setMid(messageId);
		relyMessage.setRelyMessagePK(relyMessagePK);
		//先查出所有的评论，然后一个个删除
		List<RelyMessage> relyMessageList = 
					relyMessageService.queryRelyMessageByMid(relyMessage);
		for(RelyMessage relyMessageTemp : relyMessageList)
		{
			relyMessageService.deleteRelyMesasge(relyMessageTemp);
		}
		//删除掉该评论中对应的at
		At at = new At();
		AtPK atPK = new AtPK();
		atPK.setMid(messageId);
		at.setAtPK(atPK);
		List<At> atList = atService.queryAt(at);
		for(At atTemp : atList)
		{
			atService.deleteAt(atTemp);
		}
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		JSONObject obj = new JSONObject();
		obj.put("isSuccess", true);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.println(obj);
		out.flush();
		out.close();
		return null;
	}
	
	public String queryMessageAndRely()
	{
		user = CommonUtils.getUserFromSession();
		//query all my message
		Message message = new Message();
		message.setUid(user.getUid());
		List<Message> messageList = messageService.queryMessage(message);
		
		//Collections.reverse(messageList);
		user.setMessageList(messageList);
		user.setMessageCount(messageList == null ? CommonConstant.ZERO_MESSAGELIST : String.valueOf(messageList.size()));
		
		//query message if has rely message
		if(null != messageList && !messageList.isEmpty())
		{
			relyMessageService.checkRelyMessageByMid(messageList);
		}
				
		return SUCCESS;
	}
}
