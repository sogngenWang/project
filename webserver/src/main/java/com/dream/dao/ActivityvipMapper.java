package com.dream.dao;

import java.util.List;

import com.dream.bean.Activity;
import com.dream.bean.Activityvip;

public interface ActivityvipMapper {
    int deleteByPrimaryKey(Integer activityid);

    int insert(Activityvip record);

    int insertSelective(Activityvip record);

    Activityvip selectByPrimaryKey(Integer activityid);

    int updateByPrimaryKeySelective(Activityvip record);

    int updateByPrimaryKey(Activityvip record);

	List<Activityvip> listActivityvip(Activity activity);
    
    
}