package com.dreamheaven.service;

import java.util.List;

import com.dreamheaven.domain.User;
import com.dreamheaven.domain.UserTmp;




public interface UserService {

	String login(User user);
	boolean logout(UserTmp userTmp);
	boolean createUser(User user);
	boolean deleteUser(User user);
	boolean updateUser(User user);
	User detailUser(User user);
	List<User> queryAllUsers(User user);
	
}
