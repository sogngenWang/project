package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Activity;
import com.dream.dao.ActivityMapper;
import com.dream.service.ActivityService;

@Repository(value = "activityService")
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityMapper activityDao;

	@Override
	public List<Activity> listActivity(Activity activity) {

		return activityDao.listActivity(activity);
	}

	@Override
	public Activity detailActivity(Activity activity) {

		return activityDao.detailActivity(activity);
	}

	@Override
	public int updateActivity(Activity activity) {

		return activityDao.updateByPrimaryKeySelective(activity);
	}

	@Override
	public int deleteActivity(int uid) {

		return activityDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addActivity(Activity activity) {

		return activityDao.insert(activity);

	}

}
