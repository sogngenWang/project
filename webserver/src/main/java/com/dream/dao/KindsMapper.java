package com.dream.dao;

import java.util.List;

import com.dream.bean.Kinds;

public interface KindsMapper {
	
    int deleteByPrimaryKey(Integer kindsid);

    int insert(Kinds record);

    int insertSelective(Kinds record);

    Kinds selectByPrimaryKey(Integer kindsid);

    int updateByPrimaryKeySelective(Kinds record);

    int updateByPrimaryKey(Kinds record);
    
	// ******************add by wsg**********************

	/**
	 * 根据条件查询，返回一个list
	 * 
	 * @param kinds
	 * @return
	 */
	List<Kinds> listKinds(Kinds kinds);

	/**
	 * 根据条件查询，返回一个对象
	 * 
	 * @param kinds
	 * @return
	 */
	Kinds detailKinds(Kinds kinds);
	
	/**
	 * 根据条件统计记录数
	 * @param kinds
	 * @return
	 */
	int countKinds(Kinds kinds);
}