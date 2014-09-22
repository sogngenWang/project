package com.dreamheaven.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.dreamheaven.dao.UserDao;
import com.dreamheaven.dao.UserTmpDao;
import com.dreamheaven.domain.User;
import com.dreamheaven.domain.UserTmp;
import com.dreamheaven.service.UserService;
import com.dreamheaven.utils.CommonUtils;

public class UserServiceImpl implements UserService{

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	private UserDao userDao;
	
	private UserTmpDao userTmpDao;
	
	public UserTmpDao getUserTmpDao() {
		return userTmpDao;
	}

	public void setUserTmpDao(UserTmpDao userTmpDao) {
		this.userTmpDao = userTmpDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean createUser(User user) {
		userDao.createLogin(user);
		return true;
	}

	public boolean deleteUser(User user) {
		userDao.deleteUser(user);
		return false;
	}

	public List<User> queryAllUsers(User user) {
		return userDao.queryUser(user);
	}

	public boolean updateUser(User user) {
		userDao.updateUser(user);
		return false;
	}

	public User detailUser(User user) {
		return userDao.detailUser(user);
	}
	
	public String login(User user) {
		//如果成功登录，则调用公共方法，生成一个唯一的key，然后插入数据库的临时表中
		User newUser = userDao.detailUser(user);
		if(null != newUser){
			logger.info("login success...");
			//通过用户的hashcode生成唯一key
			String onlyKey = CommonUtils.generateKeyByUser(newUser);
			System.out.println(onlyKey);
			UserTmp userTmp = new UserTmp();
			if(!StringUtils.isBlank(onlyKey)){
				userTmp.setUid(newUser.getUid());
				userTmp.setUserSessionId(onlyKey);
				userTmp.setStartTime(CommonUtils.generateDateString(new Date()));
				userTmpDao.createUserTmp(userTmp);
				logger.info("create user session successfully ...session is "+onlyKey);
				return onlyKey;
			}
		}
		return "";
	}
	
	//userTmp对象中应该只有sessionId字段不为空
	public boolean logout(UserTmp userTmp){
		userTmpDao.deleteUserTmp(userTmp);
		logger.info("logout success...");
		return false;
	}

}
