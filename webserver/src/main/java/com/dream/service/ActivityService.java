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

	/**
	 * 活动详情页需要用到的活动相关信息
	 * @param activity
	 * @return
	 */
	Activity detailActivityPage(Activity activity);

	/**
	 * 返回的值表示该活动是否正在报名ing
	 * @param activityid
	 * @return
	 */
	boolean isRegistering(Integer activityid);
	
}
