package com.dream.dao;

import java.util.List;

import com.dream.bean.Registeractivity;

public interface RegisteractivityMapper {
	int deleteByPrimaryKey(Integer registrationid);

	int insert(Registeractivity record);

	int insertSelective(Registeractivity record);

	Registeractivity selectByPrimaryKey(Integer registrationid);

	int updateByPrimaryKeySelective(Registeractivity record);

	int updateByPrimaryKey(Registeractivity record);

	// ******************add by wsg**********************

	/**
	 * 根据条件查询，返回一个list
	 * 
	 * @param registeractivity
	 * @return
	 */
	List<Registeractivity> listRegisteractivity(Registeractivity registeractivity);

	/**
	 * 根据条件查询，返回一个对象
	 * 
	 * @param registeractivity
	 * @return
	 */
	Registeractivity detailRegisteractivity(Registeractivity registeractivity);

	/**
	 * 根据条件统计记录数
	 * 
	 * @param registeractivity
	 * @return
	 */
	int countRegisteractivity(Registeractivity registeractivity);
}