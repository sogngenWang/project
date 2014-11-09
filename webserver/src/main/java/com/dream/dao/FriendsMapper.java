package com.dream.dao;

import java.util.List;

import com.dream.bean.Friends;

public interface FriendsMapper {
    int deleteByPrimaryKey(Integer friendid);

    int insert(Friends record);

    int insertSelective(Friends record);

    Friends selectByPrimaryKey(Integer friendid);

    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKey(Friends record);
    // ******************add by wsg**********************

 	/**
 	 * 根据条件查询，返回一个list
 	 * 
 	 * @param friends
 	 * @return
 	 */
 	List<Friends> listFriends(Friends friends);

 	/**
 	 * 根据条件查询，返回一个对象
 	 * 
 	 * @param friends
 	 * @return
 	 */
 	Friends detailFriends(Friends friends);
 	
 	/**
 	 * 根据条件统计记录数
 	 * @param friends
 	 * @return
 	 */
 	int countFriends(Friends friends);
 	/**
 	 * 根据条件，改变好友关系的状态
 	 * @param friends
 	 * @return
 	 */
 	int updateFriendsStatus(Friends friends);
}