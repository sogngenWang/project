package com.dreamheaven.relymessage.dao;

import java.util.List;

import com.dreamheaven.relymessage.domain.RelyMessage;

public interface RelyMessageDao {

	int countRelyMessage(RelyMessage relyMessage);

	List<RelyMessage> queryRelyMessage(RelyMessage relyMessage);

	void createRelyMessage(RelyMessage relyMessage);

	void deleteRelyMessage(RelyMessage relyMessage);

}
