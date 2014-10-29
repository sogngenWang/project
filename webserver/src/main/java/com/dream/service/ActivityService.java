package com.dream.service;

import java.util.List;

import com.dream.bean.Activity;

public interface ActivityService {

	List<Activity> listActivity(Activity activity);
	
	Activity detailActivity(Activity activity);

	int updateActivity(Activity activity);
	
	int deleteActivity(int uid);
	
	int addActivity(Activity activity);
	
	int countActivity(Activity activity);
	
}
