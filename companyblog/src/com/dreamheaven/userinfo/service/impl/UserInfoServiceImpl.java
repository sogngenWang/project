package com.dreamheaven.userinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.userinfo.dao.UserInfoDao;
import com.dreamheaven.userinfo.domain.UserInfo;
import com.dreamheaven.userinfo.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoDao userInfoDao ;
	
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}


	//通过随机数，随机获取同一公司内的其他人的详细信息。
	@Override
	public List<UserInfo> getOhtersInofInSameCompany(UserInfo userInfo) {
		//query list
		List<UserInfo> userInfoList = userInfoDao.queryExceptUser(userInfo);

		int listCount  = userInfoList.size();
		
		List<UserInfo> othersInCompany = new ArrayList<UserInfo>();
		
		//if greater than 5 than get 5 items,else get allv
		if(listCount >= 3 )
		{
			int[] randomNumberArray = CommonUtils.getRandomNumber(listCount);
			for(int i=0;i < 3 ; i ++){
				int randomNumber = randomNumberArray[i];
				othersInCompany.add(userInfoList.get(randomNumber));
			}
			return othersInCompany;
		}
		else
		{
			return userInfoList;
		}
		
	}


	@Override
	public UserInfo detailUserInfo(UserInfo userInfo) {
		
		userInfo = userInfoDao.detailUserInfo(userInfo);
		
		return userInfo;
	}


	@Override
	public void createUserInfo(UserInfo userInfo) {
		
		userInfoDao.createUserInfo(userInfo);
		
	}


	@Override
	public List<UserInfo> queryUserInfo(UserInfo userInfo) {
		
		return userInfoDao.queryUserInfo(userInfo);
	}
	
	
	
	

}
