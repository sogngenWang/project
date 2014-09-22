package com.dream.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.dream.bean.User;
import com.dream.dao.UserDao;
import com.dream.service.UserService;

@Repository(value = "userService")
public class UserServiceImpl implements UserService {

	@Resource(name = "userDao")
	private UserDao userDao;

	@Override
	public User detailUser(User user) {
		return userDao.detailUser(user);
	}

	@Override
	public List<User> listUser(User user) {
		return userDao.listUser(user);
	}

	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

}
