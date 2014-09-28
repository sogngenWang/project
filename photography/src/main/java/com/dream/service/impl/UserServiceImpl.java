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
	public boolean login(User user) {
		String username = user.getUsername();
		User userTmp = new User();
		userTmp.setUsername(username);
		userTmp = userDao.detailUser(userTmp);
		//如果数据库中有这个用户名,同时这个用户的密码不为空,则判断密码是否匹配,匹配则返回true
		if(null != userTmp && !userTmp.getPasswd().isEmpty()){
			if(user.getPasswd().endsWith(userTmp.getPasswd())){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean register(User user) {
		// 判断用户名是否存在，如果用户名不存在则新建该用户
		User userTmp = new User();
		userTmp.setUsername(user.getUsername());
		userTmp = userDao.detailUser(userTmp);
		if(null == userTmp && !user.getPasswd().isEmpty()){
			userDao.insert(user);
			return true;
		}else{
			// TODO 抛出业务异常
			System.out.println("||||userServiceImpl Exception|||||");
		}
		return false;
	}
	
	

}
