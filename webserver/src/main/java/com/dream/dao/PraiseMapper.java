package com.dream.dao;

import java.util.List;

import com.dream.bean.Praise;

public interface PraiseMapper {
    int deleteByPrimaryKey(Integer praiseid);

    int insert(Praise record);

    int insertSelective(Praise record);

    Praise selectByPrimaryKey(Integer praiseid);

    int updateByPrimaryKeySelective(Praise record);

    int updateByPrimaryKey(Praise record);

	int countPraise(Praise praise);

	Praise detailPraise(Praise praise);

	List<Praise> listPraise(Praise praise);
}