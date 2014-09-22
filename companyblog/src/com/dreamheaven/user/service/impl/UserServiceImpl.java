package com.dreamheaven.user.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.dreamheaven.common.constant.CommonConstant;
import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.user.constant.UserConstant;
import com.dreamheaven.user.dao.UserDao;
import com.dreamheaven.user.domain.User;
import com.dreamheaven.user.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public String getActiveStatus(User user){
		
		User userTemp = userDao.detailUser(user);
		return userTemp.getActive();
	}

	@Override
	public String checkUser(User user) {
		try
		{
			
		String password = user.getPassword();
		if(StringUtils.isBlank(password))
		{
			throw new Exception("password is blank...");
		}
		List<User> list = userDao.searchUser(user);
		if(list.isEmpty())
		{
			return null;
		}
		user = list.get(0);
		if(null != user && password.equals(user.getPassword())){
			//login success
			CommonUtils.getSession().put(CommonConstant.LOGINUSER,user);
			
			return user.getUserType();
		}
		

		}catch(Exception e)
		{
			user.setErrorInfo(e.getMessage());
		}
		
		return null;
	}

	@Override
	public void addUserNotActive(User user) {
		
		user.setActive(UserConstant.USER_NOTACTIVE_FLAG);
		
		userDao.create(user);

	}

	@Override
	public User detailUser(User user) {
		
		return userDao.detailUser(user);
	}

	@Override
	public void deleteUser(User user) {
		
		userDao.delete(user);
		
	}

	@Override
	public void activeUser(User user) {
		user = userDao.detailUser(user);
		user.setActive(UserConstant.USER_ACTIVE_FLAG);
		userDao.update(user);
	}

	@Override
	public void forbidUser(User user) {
		user = userDao.detailUser(user);
		user.setActive(UserConstant.USER_NOTACTIVE_FLAG);
		userDao.update(user);
	}

}
