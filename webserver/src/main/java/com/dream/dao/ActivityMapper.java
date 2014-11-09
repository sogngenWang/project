package com.dream.dao;

import java.util.List;

import com.dream.bean.Activity;

public interface ActivityMapper {
 
    int deleteByPrimaryKey(Integer activityid);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer activityid);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);
    
    
	// ******************add by wsg**********************

	/**
	 * 根据条件查询，返回一个list
	 * 
	 * @param activity
	 * @return
	 */
	List<Activity> listActivity(Activity activity);

	/**
	 * 根据条件查询，返回一个对象
	 * 
	 * @param activity
	 * @return
	 */
	Activity detailActivity(Activity activity);
	
	/**
	 * 根据条件统计记录数
	 * @param activity
	 * @return
	 */
	int countActivity(Activity activity);

	/**
	 * 
	 * @param i
	 * @return
	 */
	int addActivityViewcount(Activity activity);
	
}