package com.dream.service;

import java.util.List;

import com.dream.bean.Registeractivity;
import com.dream.bean.User;

public interface RegisteractivityService {

	List<Registeractivity> listRegisteractivity(Registeractivity registeractivity);
	
	Registeractivity detailRegisteractivity(Registeractivity registeractivity);

	int updateRegisteractivity(Registeractivity registeractivity);
	
	int deleteRegisteractivity(int uid);
	
	int addRegisteractivity(Registeractivity registeractivity);
	
	int countRegisteractivity(Registeractivity registeractivity);

	int countRegisterSign(Registeractivity registeractivity);

	List<User> listRegisterSignUser(Registeractivity registeractivity);

	/**
	 * 用户是否已经签到
	 * @param registeractivity
	 * @return
	 */
	boolean isUserSign(Registeractivity registeractivity);

	/**
	 * 报名是否已经到达上限
	 * @param activityid
	 * @return
	 */
	boolean isUpperRegist(Integer activityid);

	/**
	 * 用户报名活动
	 * @param registeractivity
	 * @return
	 */
	int userRegisteractivity(Registeractivity registeractivity);

}
