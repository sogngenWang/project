package com.dream.weddingexpo.service;

import java.util.List;

import com.dream.weddingexpo.bean.User;

public interface UserService {

	User detailUser(User user);

	List<User> listUser(User user);

	void addUser(User user) ;
	
	List<User> listUserNoContent(User user);
	
	void deleteUser(User user);

	User updateUser(User user);

}
