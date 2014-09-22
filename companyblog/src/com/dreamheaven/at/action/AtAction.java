package com.dreamheaven.at.action;

import java.util.ArrayList;
import java.util.List;

import com.dreamheaven.at.constant.AtConstant;
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

public class AtAction  extends ActionSupport{ 
	
	private static final long serialVersionUID = -4342452975020551567L;
	
	private AtService atService ;
	private UserInfoService userInfoService ;
	private MessageService messageService ;
	private RelyMessageService relyMessageService ;
	
	private At at;
	
	public AtService getAtService() {
		return atService;
	}

	public void setAtService(AtService atService) {
		this.atService = atService;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public RelyMessageService getRelyMessageService() {
		return relyMessageService;
	}

	public void setRelyMessageService(RelyMessageService relyMessageService) {
		this.relyMessageService = relyMessageService;
	}

	public At getAt() {
		return at;
	}

	public void setAt(At at) {
		this.at = at;
	}

	public String queryAtMeMessage()
	{
		String atUid = CommonUtils.getUserFromSession().getUid();
		AtPK atPK = new AtPK();
		atPK.setAtUid(atUid);
		atPK.setAtType(AtConstant.AT_TYPE_MESSAGE_AT);
		at.setAtPK(atPK);
		//先查出所有被通过微博直接@到的mid
		List<At> atList = atService.queryAt(at);
		List<Message> atMeMessageList = new ArrayList<Message>();
		for(At atTemp : atList)
		{
			//获取每一条记录的详细信息以及发布人或者回复人的信息
			
			//获取该条message的详细信息
			Message messageTemp = new Message();
			messageTemp.setMid(atTemp.getAtPK().getMid());
			messageTemp = messageService.queryMessage(messageTemp).get(0);
			
			//获取发布该message的用户的详细信息
			UserInfo userInfoTemp = new UserInfo();
			userInfoTemp.setUid(atTemp.getAtPK().getAtUid());
			userInfoTemp = userInfoService.detailUserInfo(userInfoTemp);
			
			//获取该message的回复信息
			List<RelyMessage> relyMessageList = new ArrayList<RelyMessage>();
			RelyMessage relyMessageTemp = new RelyMessage();
			RelyMessagePK relyMessagePK = new RelyMessagePK();
			relyMessagePK.setMid(atTemp.getAtPK().getMid());
			relyMessageTemp.setRelyMessagePK(relyMessagePK);
			relyMessageList = relyMessageService.queryRelyMessageByMid(relyMessageTemp);
			
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
			
			atMeMessageList.add(messageTemp);
		}
		
		at.setAtMeMessageList(atMeMessageList);
		
		return SUCCESS;
	}
	
	public String queryAtMeRelyMessage()
	{
		String atUid = CommonUtils.getUserFromSession().getUid();
		AtPK atPK = new AtPK();
		atPK.setAtUid(atUid);
		atPK.setAtType(AtConstant.AT_TYPE_RELYMESSAGE_AT);
		at.setAtPK(atPK);
		//先查出所有被通过微博直接@到的mid
		List<At> atList = atService.queryAt(at);
		//去掉重复的mid
		
		List<String> atListTemp = new ArrayList<String>();
//		Set<At> atSet = new HashSet<At>();
//		for(At atTemp : atList )
//		{
//			if(atList.contains(atTemp))
//			{
//				atListTemp.add(atTemp);
//			}
//		}
		
		List<Message> atMeMessageList = new ArrayList<Message>();
		for(At atTemp : atList)
		{
			if(atListTemp.contains(atTemp.getAtPK().getMid()))
			{
				continue;
			}
			//获取每一条记录的详细信息以及发布人或者回复人的信息
			
			//获取该条message的详细信息
			Message messageTemp = new Message();
			messageTemp.setMid(atTemp.getAtPK().getMid());
			messageTemp = messageService.queryMessage(messageTemp).get(0);
			
			//获取发布该message的用户的详细信息
			UserInfo userInfoTemp = new UserInfo();
			userInfoTemp.setUid(atTemp.getAtPK().getAtUid());
			userInfoTemp = userInfoService.detailUserInfo(userInfoTemp);
			
			//获取该message的回复信息
			List<RelyMessage> relyMessageList = new ArrayList<RelyMessage>();
			RelyMessage relyMessageTemp = new RelyMessage();
			RelyMessagePK relyMessagePK = new RelyMessagePK();
			relyMessagePK.setMid(atTemp.getAtPK().getMid());
			relyMessageTemp.setRelyMessagePK(relyMessagePK);
			relyMessageList = relyMessageService.queryRelyMessageByMid(relyMessageTemp);
			
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
			
			atMeMessageList.add(messageTemp);
			atListTemp.add(atTemp.getAtPK().getMid());
		}
		
		at.setAtMeMessageList(atMeMessageList);
		
		return SUCCESS;
	}
	
}
