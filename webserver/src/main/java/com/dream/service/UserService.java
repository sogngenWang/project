package com.dream.service;

import java.util.List;

import com.dream.basebean.PageBase;
import com.dream.bean.Friends;
import com.dream.bean.User;

public interface UserService {

	List<User> listUser(User user);
	
	User detailUser(User user);

	int updateUser(User user);
	
	int deleteUser(int uid);
	
	int addUser(User user);
	
	int countUser(User user);
	
	int updateByTelephone(User user);

	int addNormalUser(User user);

	User loginUser(User user);

	User detailUserForFriends(Friends friendsTmp);

	List<User> listOnceUser(User user, PageBase pageBase);
}
