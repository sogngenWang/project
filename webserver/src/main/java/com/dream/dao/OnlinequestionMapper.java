package com.dream.dao;

import com.dream.bean.Onlinequestion;

public interface OnlinequestionMapper {
    int deleteByPrimaryKey(Integer questionid);

    int insert(Onlinequestion record);

    int insertSelective(Onlinequestion record);

    Onlinequestion selectByPrimaryKey(Integer questionid);

    int updateByPrimaryKeySelective(Onlinequestion record);

    int updateByPrimaryKey(Onlinequestion record);
}