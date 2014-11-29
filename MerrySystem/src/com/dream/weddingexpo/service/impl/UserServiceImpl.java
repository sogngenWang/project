package com.dream.weddingexpo.service.impl;

import java.util.List;

import com.dream.weddingexpo.bean.User;
import com.dream.weddingexpo.dao.UserDao;
import com.dream.weddingexpo.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {

		userDao.addUser(user);
	}

	@Override
	public List<User> listUser(User user) {
		List<User> userList = userDao.userList(user);

		return userList;
	}

	@Override
	public User detailUser(User user) {
		user = userDao.detailUser(user);
		return user;
	}

	@Override
	public List<User> listUserNoContent(User user) {
		List<User> userList = userDao.userList(user);
		return userList;
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	@Override
	public User updateUser(User user) {

		return userDao.updateUser(user);
	}

}
