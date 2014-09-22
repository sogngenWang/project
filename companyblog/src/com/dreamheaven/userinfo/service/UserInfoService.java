package com.dreamheaven.userinfo.service;

import java.util.List;

import com.dreamheaven.userinfo.domain.UserInfo;

public interface UserInfoService {
	
	List<UserInfo> getOhtersInofInSameCompany(UserInfo userInfo);
	
	UserInfo detailUserInfo(UserInfo userInfo);
	
	void createUserInfo(UserInfo userInfo);
	
	List<UserInfo> queryUserInfo(UserInfo userInfo);
	
}
