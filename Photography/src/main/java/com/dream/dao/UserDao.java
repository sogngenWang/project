package com.dream.dao;

import java.util.List;

import com.dream.bean.User;

public interface UserDao {
	
	User detailUser(User user);

	List<User> listUser(User user);

	User updateUser(User user);

	void addUser(User user);

	void deleteUser(User user);
}
