package com.dream.dao;

import java.util.List;

import com.dream.bean.User;

public interface UserMapper {
	
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
	// ******************add by wsg**********************

	/**
	 * 根据条件查询，返回一个list
	 * 
	 * @param user
	 * @return
	 */
	List<User> listUser(User user);

	/**
	 * 根据条件查询，返回一个对象
	 * 
	 * @param user
	 * @return
	 */
	User detailUser(User user);
	
	/**
	 * 根据条件统计记录数
	 * @param user
	 * @return
	 */
	int countUser(User user);
	/**
	 * 根据传入的手机号去更新其他字段
	 * @param user
	 * @return
	 */
	int updateByTelephone(User user);

	/**
	 * 提供给activityvip的接口
	 * @param user
	 * @return
	 */
	User detailUser4Activityvip(int userid);

	/**
	 * 提供给Friends的接口
	 * @param user
	 * @return
	 */
	User detailUser2Friends(User user);

	/**
	 * 提供给Activity的接口
	 * @param userTmp
	 * @return
	 */
	User detailUser4Activity(User userTmp);
}