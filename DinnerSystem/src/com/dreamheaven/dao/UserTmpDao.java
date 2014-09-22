package com.dreamheaven.dao;

import java.util.List;

import com.dreamheaven.domain.UserTmp;



public interface UserTmpDao {

	int countUserTmp(UserTmp userTmp);

	void deleteUserTmp(UserTmp userTmp);

	void createUserTmp(UserTmp userTmp);
	
	void updateUserTmp(UserTmp userTmp);
	
	UserTmp detailUserTmp(UserTmp userTmp);
	
	List<UserTmp> queryUserTmp(UserTmp userTmp) ;
	
	
}
