package com.dreamheaven.relymessage.service;

import java.util.List;

import com.dreamheaven.message.domain.Message;
import com.dreamheaven.relymessage.domain.RelyMessage;

public interface RelyMessageService {

	void checkRelyMessageByMid(List<Message> messageList);
	
	List<RelyMessage> queryRelyMessageByMid(RelyMessage relyMessage);

	void createRelyMessage(RelyMessage relyMessage);
	
	int countRelyMessage(RelyMessage relyMessage);
	
	void deleteRelyMesasge(RelyMessage relyMessage);
}
