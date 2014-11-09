package com.dream.service;

import java.util.List;

import com.dream.basebean.PageBase;
import com.dream.bean.Activity;
import com.dream.bean.Friends;
import com.dream.bean.User;

public interface FriendsService {

	List<Friends> listFriends(Friends friends);
	
	Friends detailFriends(Friends friends);

	int updateFriends(Friends friends);
	
	int deleteFriends(int uid);
	
	int addFriends(Friends friends);
	
	int countFriends(Friends friends);


	List<Friends> listReceiveFriends(Friends friends, PageBase pageBase);

	List<Friends> listSendFriends(Friends friends, PageBase pageBase);

	Activity addANewFriends(Friends friends);

	void manageFriendsAdd(Friends friends);

	List<User> listAllFriends(Friends friends, PageBase pageBase);


	Friends detailFriendsStatus(Friends friends);


}
