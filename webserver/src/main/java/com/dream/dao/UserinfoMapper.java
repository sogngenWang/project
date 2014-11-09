package com.dream.dao;

import java.util.List;

import com.dream.bean.Userinfo;

public interface UserinfoMapper {

    int deleteByPrimaryKey(Integer userid);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    
	// ******************add by wsg**********************

	/**
	 * 根据条件查询，返回一个list
	 * 
	 * @param userinfo
	 * @return
	 */
	List<Userinfo> listUserinfo(Userinfo userinfo);

	/**
	 * 根据条件查询，返回一个对象
	 * 
	 * @param userinfo
	 * @return
	 */
	Userinfo detailUserinfo(Userinfo userinfo);
	
	/**
	 * 根据条件统计记录数
	 * @param userinfo
	 * @return
	 */
	int countUserinfo(Userinfo userinfo);
}