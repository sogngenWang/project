package com.dream.service;

import java.util.List;

import com.dream.bean.User;

public interface UserService {

	List<User> listUser(User user);
	
	User detailUser(User user);

	String updateUser(User user);
	
	String deleteUser(String uid);
	
	String addUser(User user);
	
}
