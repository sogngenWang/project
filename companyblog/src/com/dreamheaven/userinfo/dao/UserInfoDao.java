package com.dreamheaven.userinfo.dao;

import java.util.List;

import com.dreamheaven.userinfo.domain.UserInfo;

public interface UserInfoDao {

	List<UserInfo> queryExceptUser(UserInfo userInfo);

	UserInfo detailUserInfo(UserInfo userInfo);

	void createUserInfo(UserInfo userInfo);

	List<UserInfo> queryUserInfo(UserInfo userInfo);
	
}
