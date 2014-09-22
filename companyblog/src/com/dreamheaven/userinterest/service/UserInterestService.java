package com.dreamheaven.userinterest.service;

import java.util.List;

import com.dreamheaven.userinterest.domain.UserInterest;

public interface UserInterestService {
	
	int countAttention(UserInterest userInterest);
	
	int countFans(UserInterest userInterest);
	
	int countUserInterest(UserInterest userInterest);

	void createListenByUid(UserInterest userInterest);
	
	List<UserInterest> queryUserInterest(UserInterest userInterest);

	UserInterest detailUserInterest(UserInterest userInterest);

	void deleteListenByUid(UserInterest userInterest);
}
