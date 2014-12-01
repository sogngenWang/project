package com.dream.dao;

import com.dream.bean.Bonuspoint;

public interface BonuspointMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Bonuspoint record);

    int insertSelective(Bonuspoint record);

    Bonuspoint selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Bonuspoint record);

    int updateByPrimaryKey(Bonuspoint record);
}