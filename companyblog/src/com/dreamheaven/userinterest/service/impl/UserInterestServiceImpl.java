package com.dreamheaven.userinterest.service.impl;

import java.util.List;

import com.dreamheaven.userinterest.dao.UserInterestDao;
import com.dreamheaven.userinterest.domain.UserInterest;
import com.dreamheaven.userinterest.service.UserInterestService;

public class UserInterestServiceImpl implements UserInterestService{

	private UserInterestDao userInterestDao ;
	
	public UserInterestDao getUserInterestDao() {
		return userInterestDao;
	}

	public void setUserInterestDao(UserInterestDao userInterestDao) {
		this.userInterestDao = userInterestDao;
	}

	@Override
	public int countAttention(UserInterest userInterest) {

		userInterest.getUserInterestPK().setListenedId(null);
		return userInterestDao.countUserInterest(userInterest);
		
	}

	@Override
	public int countFans(UserInterest userInterest) {

		userInterest.getUserInterestPK().setUid(null);
		return userInterestDao.countUserInterest(userInterest);
		
	}

	@Override
	public void createListenByUid(UserInterest userInterest) {
		
		userInterestDao.createUserInterest(userInterest);
		
	}

	@Override
	public List<UserInterest> queryUserInterest(UserInterest userInterest) {
	
		return userInterestDao.queryUserInterest(userInterest);
	}

	@Override
	public UserInterest detailUserInterest(UserInterest userInterest) {
		
		return userInterestDao.detailUserInterest(userInterest);
	}

	@Override
	public int countUserInterest(UserInterest userInterest) {
		
		return userInterestDao.countUserInterest(userInterest);
	}

	@Override
	public void deleteListenByUid(UserInterest userInterest) {
		
		userInterestDao.deleteUserInterest(userInterest);
	}

}
