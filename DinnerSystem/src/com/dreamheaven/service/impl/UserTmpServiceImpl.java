package com.dreamheaven.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.dreamheaven.dao.UserTmpDao;
import com.dreamheaven.domain.UserTmp;
import com.dreamheaven.service.UserTmpService;

public class UserTmpServiceImpl implements UserTmpService{

	private static Logger logger = Logger.getLogger(UserTmpServiceImpl.class);
	
	public UserTmpDao userTmpDao;

	public UserTmpDao getUserTmpDao() {
		return userTmpDao;
	}

	public void setUserTmpDao(UserTmpDao userTmpDao) {
		this.userTmpDao = userTmpDao;
	}

	public boolean createUserTmp(UserTmp userTmp) {
		userTmpDao.createUserTmp(userTmp);
		return false;
	}

	public boolean deleteUserTmp(UserTmp userTmp) {
		userTmpDao.deleteUserTmp(userTmp);
		return false;
	}

	public UserTmp detailUserTmp(UserTmp userTmp) {
		return userTmpDao.detailUserTmp(userTmp);
	}

	public List<UserTmp> queryAllUsersTmps(UserTmp userTmp) {
		
		return userTmpDao.queryUserTmp(userTmp);
	}

	public boolean updateUserTmp(UserTmp userTmp) {
		userTmpDao.updateUserTmp(userTmp);
		return false;
	}
	


}
