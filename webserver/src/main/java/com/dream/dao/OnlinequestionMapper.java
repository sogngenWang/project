package com.dream.dao;

import java.util.List;

import com.dream.bean.Onlinequestion;

public interface OnlinequestionMapper {
    int deleteByPrimaryKey(Integer questionid);

    int insert(Onlinequestion record);

    int insertSelective(Onlinequestion record);

    Onlinequestion selectByPrimaryKey(Integer questionid);

    int updateByPrimaryKeySelective(Onlinequestion record);

    int updateByPrimaryKey(Onlinequestion record);

	int countOnlinequestion(Onlinequestion onlinequestion);

	Onlinequestion detailOnlinequestion(Onlinequestion onlinequestion);

	List<Onlinequestion> listOnlinequestion(Onlinequestion onlinequestion);
}