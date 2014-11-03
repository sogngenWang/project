package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.User;
import com.dream.constants.Constant;
import com.dream.dao.UserMapper;
import com.dream.service.UserService;
import com.dream.utils.CommonUtils;

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

	@Override
	public int addNormalUser(User user) {
		//设置用户状态等等
		user.setIsactive(Constant.USER_ACTIVE);
		user.setRegistertime(CommonUtils.getSYSDate());
		user.setType(Constant.USER_NORMAL_TYPE);
		return userDao.insert(user);
	}

	@Override
	public User loginUser(User user) {

		user.setIsactive(Constant.USER_ACTIVE);
		user.setType(Constant.USER_NORMAL_TYPE);
		
		user = userDao.detailUser(user);
		user.setPassword(null);
		user.setIsactive(null);
		user.setType(null);
		
		return user;
	}

}
