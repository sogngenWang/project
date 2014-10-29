package com.dream.service;

import java.util.List;

import com.dream.bean.Userinfo;

public interface UserinfoService {

	List<Userinfo> listUserinfo(Userinfo userinfo);
	
	Userinfo detailUserinfo(Userinfo userinfo);

	int updateUserinfo(Userinfo userinfo);
	
	int deleteUserinfo(int uid);
	
	int addUserinfo(Userinfo userinfo);
	
	int countUserinfo(Userinfo userinfo);
}
