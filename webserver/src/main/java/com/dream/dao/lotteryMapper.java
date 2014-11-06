package com.dream.dao;

import com.dream.bean.lottery;

public interface lotteryMapper {
    int deleteByPrimaryKey(Integer drawid);

    int insert(lottery record);

    int insertSelective(lottery record);

    lottery selectByPrimaryKey(Integer drawid);

    int updateByPrimaryKeySelective(lottery record);

    int updateByPrimaryKey(lottery record);
}