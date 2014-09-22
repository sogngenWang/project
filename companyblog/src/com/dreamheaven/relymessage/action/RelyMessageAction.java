package com.dreamheaven.relymessage.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.dreamheaven.at.domain.At;
import com.dreamheaven.at.domain.AtPK;
import com.dreamheaven.at.service.AtService;
import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.message.domain.Message;
import com.dreamheaven.message.service.MessageService;
import com.dreamheaven.relymessage.domain.RelyMessage;
import com.dreamheaven.relymessage.domain.RelyMessagePK;
import com.dreamheaven.relymessage.service.RelyMessageService;
import com.dreamheaven.userinfo.domain.UserInfo;
import com.dreamheaven.userinfo.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class RelyMessageAction extends ActionSupport{
	
	private static final long serialVersionUID = -6440328044751043168L;

	private String messageId;
	
	private RelyMessage relyMessage;
	private Message message ;

	private RelyMessageService relyMessageService ;
	private MessageService messageService ;
	private UserInfoService userInfoService ;
	private AtService atService ;
	
	public RelyMessageService getRelyMessageService() {
		return relyMessageService;
	}

	public void setRelyMessageService(RelyMessageService relyMessageService) {
		this.relyMessageService = relyMessageService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public AtService getAtService() {
		return atService;
	}

	public void setAtService(AtService atService) {
		this.atService = atService;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public RelyMessage getRelyMessage() {
		return relyMessage;
	}

	public void setRelyMessage(RelyMessage relyMessage) {
		this.relyMessage = relyMessage;
	}
	
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String execute()
	{
		return null;
	}
	
	public String queryRelyMessage()
	{
		try{

		//----------------------------
		RelyMessage relyMessage = new RelyMessage();
		RelyMessagePK relyMessagePK =new RelyMessagePK();
		relyMessagePK.setMid(messageId);
		relyMessage.setRelyMessagePK(relyMessagePK);
		List<RelyMessage>  relyMessageList = relyMessageService.queryRelyMessageByMid(relyMessage);
		List<RelyMessage> relyMessageListDisplay = new ArrayList<RelyMessage>(relyMessageList.size());
		//对查询出来的relyMessage按照seqNum排序
		for(RelyMessage relyMessageTemp : relyMessageList)
		{
			//先查询出每条记录所对应的回复人的昵称
			UserInfo userInfo = new UserInfo();
			userInfo.setUid(relyMessageTemp.getUid());
			userInfo = userInfoService.detailUserInfo(userInfo);
			relyMessageTemp.setRelyUserNickName(userInfo.getNickName());
			relyMessageTemp.setRelyUserPath(userInfo.getHeadImgPath());
			String relySeqNum = relyMessageTemp.getRelyMessagePK().getRelySeqNum();
			relyMessageListDisplay.add(Integer.valueOf(relySeqNum)-1, relyMessageTemp);
		}
		
		//----------返回的值应该是relyMessageListDisplay--------------
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		JSONArray obj = JSONArray.fromObject(relyMessageListDisplay); // 集合转为json
		PrintWriter out = response.getWriter();
		out.println(obj.toString());
		out.flush();
		out.close();
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public String createRelyMessage()
	{
		RelyMessage relyMessageTemp = new RelyMessage();
		RelyMessagePK relyMessagePK = new RelyMessagePK();
		relyMessagePK.setMid(messageId);
		relyMessageTemp.setRelyMessagePK(relyMessagePK);
		int countRelyMessage = relyMessageService.countRelyMessage(relyMessageTemp);
		
		relyMessage.setRelyMessagePK(relyMessagePK);
		relyMessage.getRelyMessagePK().setRelySeqNum(String.valueOf(countRelyMessage+1));
		relyMessage.setRelyTime(CommonUtils.getNowTime());
		relyMessage.setUid(CommonUtils.getUserFromSession().getUid());
		
		Set<String> atUserSet =  CommonUtils.generateAtAndRContent(relyMessage);

		relyMessageService.createRelyMessage(relyMessage);
		
		At at = new At();
		AtPK atPK = at.getAtPK();
		atPK.setMid(relyMessage.getRelyMessagePK().getMid());
		atPK.setSeqNum(String.valueOf(countRelyMessage+1));
		atPK.setAtType("2");
		for(String uidTemp : atUserSet)
		{
			atPK.setAtUid(uidTemp);
			atService.createAt(at);
		}
		
		
		return SUCCESS;
	}
	
	public String recieveComment()
	{

		//要先从message中获得当前uid所有的message，然后再对relyMessage中遍历每一个mid
		String uid = CommonUtils.getUserFromSession().getUid();
		message.setUid(uid);
		List<Message> messageList = messageService.queryMessage(message);
		
		List<Message> recieveCommentList = new ArrayList<Message>();

 		List<String> messageMidList = new ArrayList<String>();
		

		//获取每一条记录的详细信息以及发布人或者回复人的信息
		for(Message messageTempInfo : messageList)
		{
			//如果这条信息是重复的，则跳过
			String mid = messageTempInfo.getMid();
			if(messageMidList.contains(mid))
			{
				continue;
			}
			messageMidList.add(mid);
			//获取该条message的详细信息
			Message messageTemp = new Message();
			messageTemp.setMid(mid);
			messageTemp = messageService.queryMessage(messageTemp).get(0);
			
			//获取发布该message的用户的详细信息
			UserInfo userInfoTemp = new UserInfo();
			userInfoTemp.setUid(messageTempInfo.getUid());
			userInfoTemp = userInfoService.detailUserInfo(userInfoTemp);
			
			//获取该message的回复信息
			List<RelyMessage> relyMessageList = new ArrayList<RelyMessage>();
			RelyMessage relyMessageTemp = new RelyMessage();
			RelyMessagePK relyMessagePK = new RelyMessagePK();
			relyMessagePK.setMid(mid);
			relyMessageTemp.setRelyMessagePK(relyMessagePK);
			relyMessageList = relyMessageService.queryRelyMessageByMid(relyMessageTemp);
			
			//如果没有回复信息，则没有表明没有收到评论
			if(null == relyMessageList || relyMessageList.isEmpty())
			{
				continue;
			}
			
			//获取回复信息的user信息
			for(RelyMessage tempReleMessage : relyMessageList)
			{
				String relyUid = tempReleMessage.getUid();
				userInfoTemp = new UserInfo();
				userInfoTemp.setUid(relyUid);
				userInfoTemp = userInfoService.detailUserInfo(userInfoTemp);

				tempReleMessage.setRelyUserNickName(userInfoTemp.getNickName());
				tempReleMessage.setRelyUserPath(userInfoTemp.getHeadImgPath());
			}
			
			messageTemp.setRelyMessageList(relyMessageList);
			messageTemp.setNickName(userInfoTemp.getNickName());
			messageTemp.setHeadPath(userInfoTemp.getHeadImgPath());
			
			recieveCommentList.add(messageTemp);
		}
		
		message.setMessageList(recieveCommentList);
		return SUCCESS;
	}
	
	public String sentComment()
	{
		//去relyMessage表中查找uid为当前登录用户的uid的即为已发送的评论
		RelyMessage relyMessage = new RelyMessage();
		relyMessage.setUid(CommonUtils.getUserFromSession().getUid());
		
		List<RelyMessage> relyMessageList = relyMessageService.queryRelyMessageByMid(relyMessage);
		
		List<String> relyMessageMidList = new ArrayList<String>();
		
		List<Message> sentCommentList = new ArrayList<Message>();

		//获取每一条记录的详细信息以及发布人或者回复人的信息
		for(RelyMessage sentCommentRelyMessage : relyMessageList)
		{
			//如果这条信息是重复的，则跳过
			String mid = sentCommentRelyMessage.getRelyMessagePK().getMid();
			if(relyMessageMidList.contains(mid))
			{
				continue;
			}
			relyMessageMidList.add(mid);
			
			//获取该条message的详细信息
			Message messageTemp = new Message();
			messageTemp.setMid(mid);
			messageTemp = messageService.queryMessage(messageTemp).get(0);
			
			//获取发布该message的用户的详细信息
			UserInfo userInfoTemp = new UserInfo();
			userInfoTemp.setUid(sentCommentRelyMessage.getUid());
			userInfoTemp = userInfoService.detailUserInfo(userInfoTemp);
			
			//获取该message的回复信息
			List<RelyMessage> relyMessageListTemp = new ArrayList<RelyMessage>();
			RelyMessage relyMessageTemp = new RelyMessage();
			RelyMessagePK relyMessagePK = new RelyMessagePK();
			relyMessagePK.setMid(mid);
			relyMessageTemp.setRelyMessagePK(relyMessagePK);
			relyMessageListTemp = relyMessageService.queryRelyMessageByMid(relyMessageTemp);
			
			//获取回复信息的user信息
			for(RelyMessage tempReleMessage : relyMessageListTemp)
			{
				String relyUid = tempReleMessage.getUid();
				userInfoTemp = new UserInfo();
				userInfoTemp.setUid(relyUid);
				userInfoTemp = userInfoService.detailUserInfo(userInfoTemp);

				tempReleMessage.setRelyUserNickName(userInfoTemp.getNickName());
				tempReleMessage.setRelyUserPath(userInfoTemp.getHeadImgPath());
			}
			
			messageTemp.setRelyMessageList(relyMessageListTemp);
			messageTemp.setNickName(userInfoTemp.getNickName());
			messageTemp.setHeadPath(userInfoTemp.getHeadImgPath());
			
			sentCommentList.add(messageTemp);
		}
		
		message.setMessageList(sentCommentList);
		
		return SUCCESS;
	}
	
}
