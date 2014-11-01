package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.User;
import com.dream.dao.UserMapper;
import com.dream.service.UserService;

@Repository(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userDao;

	@Override
	public List<User> listUser(User user) {

		return userDao.listUser(user);
	}

	@Override
	public User detailUser(User user) {

		return userDao.detailUser(user);
	}

	@Override
	public int updateUser(User user) {

		return userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public int deleteUser(int uid) {

		return userDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addUser(User user) {

		return userDao.insert(user);

	}

	@Override
	public int countUser(User user) {

		return userDao.countUser(user);
	}

	@Override
	public int updateByTelephone(User user) {
		
		return userDao.updateByTelephone(user);
	}

}
