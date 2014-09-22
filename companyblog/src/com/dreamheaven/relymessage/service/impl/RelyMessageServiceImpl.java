package com.dreamheaven.relymessage.service.impl;

import java.util.List;

import com.dreamheaven.message.constant.MessageConstant;
import com.dreamheaven.message.domain.Message;
import com.dreamheaven.relymessage.dao.RelyMessageDao;
import com.dreamheaven.relymessage.domain.RelyMessage;
import com.dreamheaven.relymessage.domain.RelyMessagePK;
import com.dreamheaven.relymessage.service.RelyMessageService;

public class RelyMessageServiceImpl implements RelyMessageService{

	private RelyMessageDao relyMessageDao ;
	
	public RelyMessageDao getRelyMessageDao() {
		return relyMessageDao;
	}
	
	public void setRelyMessageDao(RelyMessageDao relyMessageDao) {
		this.relyMessageDao = relyMessageDao;
	}

	@Override
	public void checkRelyMessageByMid(List<Message> messageList) {
		//遍历所有的message,通过mid判断是否有relyMessage，如果有则对应的Message的relyFlag为1
		for(Message messageTemp : messageList)
		{
			RelyMessage relyMessegTemp = new RelyMessage();
			RelyMessagePK relyMessagePKTemp = new RelyMessagePK();
			relyMessagePKTemp.setMid(messageTemp.getMid());
			relyMessegTemp.setRelyMessagePK(relyMessagePKTemp);
			
			int countRelyMessage = countRelyMessage(relyMessegTemp);
			
			if(countRelyMessage > 0)
			{
				messageTemp.setRelyFlag(MessageConstant.RELY_FLAG);
			}
			
		}
		
	}
	
	public int countRelyMessage(RelyMessage relyMessage){
		
		int countRelyMessage = relyMessageDao.countRelyMessage(relyMessage);
		
		return countRelyMessage;
	}

	@Override
	public List<RelyMessage> queryRelyMessageByMid(RelyMessage relyMessage) {
		
		return relyMessageDao.queryRelyMessage(relyMessage);
	}

	@Override
	public void createRelyMessage(RelyMessage relyMessage) {
		
		relyMessageDao.createRelyMessage(relyMessage);
		
	}

	@Override
	public void deleteRelyMesasge(RelyMessage relyMessage) {
		
		relyMessageDao.deleteRelyMessage(relyMessage);
	}
	
	

}
