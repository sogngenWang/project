package com.dream.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Activity;
import com.dream.bean.Registeractivity;
import com.dream.bean.User;
import com.dream.constants.Constant;
import com.dream.dao.ActivityMapper;
import com.dream.dao.RegisteractivityMapper;
import com.dream.dao.UserMapper;
import com.dream.service.RegisteractivityService;

@Repository(value = "registeractivityService")
public class RegisteractivityServiceImpl implements RegisteractivityService {

	@Autowired
	private RegisteractivityMapper registeractivityDao;
	@Autowired
	private UserMapper userDao;
	@Autowired
	private ActivityMapper activityDao;
	

	@Override
	public List<Registeractivity> listRegisteractivity(Registeractivity registeractivity) {

		return registeractivityDao.listRegisteractivity(registeractivity);
	}

	@Override
	public Registeractivity detailRegisteractivity(Registeractivity registeractivity) {

		return registeractivityDao.detailRegisteractivity(registeractivity);
	}

	@Override
	public int updateRegisteractivity(Registeractivity registeractivity) {

		return registeractivityDao.updateByPrimaryKeySelective(registeractivity);
	}

	@Override
	public int deleteRegisteractivity(int uid) {

		return registeractivityDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addRegisteractivity(Registeractivity registeractivity) {

		return registeractivityDao.insert(registeractivity);

	}

	@Override
	public int countRegisteractivity(Registeractivity registeractivity) {

		return registeractivityDao.countRegisteractivity(registeractivity);
	}

	@Override
	public int countRegisterSign(Registeractivity registeractivity) {
		registeractivity.setSignstatus(Constant.REGISTERACTIVITY_SIGN);
		return registeractivityDao.countRegisteractivity(registeractivity);
	}

	@Override
	public List<User> listRegisterSignUser(Registeractivity registeractivity) {
		registeractivity.setSignstatus(Constant.REGISTERACTIVITY_SIGN); 
		registeractivity.setUserid(null);
		List<Registeractivity> registeractivityList = registeractivityDao.listRegisteractivity(registeractivity);
		List<User> userList = new ArrayList<User>();
		for (Registeractivity registeractivityTmp : registeractivityList) {
			User user = new User();
			user.setUserid(registeractivityTmp.getUserid());
			user = userDao.detailUser(user);
			user.setPassword(null);
			user.setIsactive(null);
			user.setType(null);
			userList.add(user);
		}
		return userList;
	}

	@Override
	public boolean isUserSign(Registeractivity registeractivity) {
		registeractivity = registeractivityDao.detailRegisteractivity(registeractivity);
		if(Constant.REGISTERACTIVITY_SIGN.equals(registeractivity.getSignstatus())){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean isUpperRegist(Integer activityid) {
		Registeractivity registeractivity = new Registeractivity();
		registeractivity.setActivityid(activityid); 
		//计算活动当前已经报名人数
		int registerCount = registeractivityDao.countRegisteractivity(registeractivity);
		//计算活动上限人数
		Activity activity = new Activity();
		activity.setActivityid(activityid); 
		activity = activityDao.detailActivity(activity);
		int activityUpperCount = activity.getActivityquota();
		if(registerCount < activityUpperCount){
			return false;
		}
		
		return true;
	}

	@Override
	public int userRegisteractivity(Registeractivity registeractivity) {
		registeractivity.setSignstatus(0);
		return registeractivityDao.insert(registeractivity);
	}
}
