package com.dream.dao;

import com.dream.bean.Prize;

public interface PrizeMapper {
    int deleteByPrimaryKey(Integer prizeid);

    int insert(Prize record);

    int insertSelective(Prize record);

    Prize selectByPrimaryKey(Integer prizeid);

    int updateByPrimaryKeySelective(Prize record);

    int updateByPrimaryKey(Prize record);
}