package com.dream.dao;

import java.util.List;

import com.dream.bean.Ad;

public interface AdMapper {
    int deleteByPrimaryKey(Integer adid);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Integer adid);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);
    
    //*****
    
    int countAd(Ad ad);
    
    List<Ad> listAd(Ad ad);
    
    Ad detailAd(Ad ad);
    
}