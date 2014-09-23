package com.dream.service;

import java.util.List;

import com.dream.bean.User;

public interface UserService {

	User detailUser(User user);

	List<User> listUser(User user);

	User updateUser(User user);

	void addUser(User user);

	void deleteUser(User user);
}
