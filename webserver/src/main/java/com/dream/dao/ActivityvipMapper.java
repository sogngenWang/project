package com.dream.dao;

import com.dream.bean.Activityvip;

public interface ActivityvipMapper {
    int deleteByPrimaryKey(Integer activityid);

    int insert(Activityvip record);

    int insertSelective(Activityvip record);

    Activityvip selectByPrimaryKey(Integer activityid);

    int updateByPrimaryKeySelective(Activityvip record);

    int updateByPrimaryKey(Activityvip record);
}