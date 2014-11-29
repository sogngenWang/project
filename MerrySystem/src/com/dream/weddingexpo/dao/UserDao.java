package com.dream.weddingexpo.dao;

import java.util.List;

import com.dream.weddingexpo.bean.User;

public interface UserDao {
	List<User> userList(User user);

	User detailUser(User user);

	void addUser(User user);

	void deleteUser(User user);

	User updateUser(User user);

}
