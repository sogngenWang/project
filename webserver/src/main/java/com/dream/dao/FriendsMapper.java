package com.dream.dao;

import com.dream.bean.Friends;

public interface FriendsMapper {
    int deleteByPrimaryKey(Integer friendid);

    int insert(Friends record);

    int insertSelective(Friends record);

    Friends selectByPrimaryKey(Integer friendid);

    int updateByPrimaryKeySelective(Friends record);

    int updateByPrimaryKey(Friends record);
}