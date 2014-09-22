package com.dreamheaven.user.service;

import com.dreamheaven.user.domain.User;

public interface UserService {
	
	String getActiveStatus(User user);
	
	String checkUser(User user);

	void addUserNotActive(User user);
	
	User detailUser(User user);
	
	void deleteUser(User user);

	void activeUser(User user);

	void forbidUser(User user);
}
