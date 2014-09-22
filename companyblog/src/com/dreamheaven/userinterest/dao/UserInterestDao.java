package com.dreamheaven.userinterest.dao;

import java.util.List;

import com.dreamheaven.userinterest.domain.UserInterest;

public interface UserInterestDao {

	void createUserInterest(UserInterest userInterest);

	List<UserInterest> queryUserInterest(UserInterest userInterest);

	UserInterest detailUserInterest(UserInterest userInterest);

	int countUserInterest(UserInterest userInterest);

	void deleteUserInterest(UserInterest userInterest);
	
}
