package com.dream.dao;

import java.util.List;

import com.dream.bean.Checkcode;

public interface CheckcodeMapper {

	int deleteByPrimaryKey(Integer checkcodeid);

	int insert(Checkcode record);

	int insertSelective(Checkcode record);

	Checkcode selectByPrimaryKey(Integer checkcodeid);

	int updateByPrimaryKeySelective(Checkcode record);

	int updateByPrimaryKey(Checkcode record);

	// ******************add by wsg**********************

	/**
	 * 根据条件查询，返回一个list
	 * 
	 * @param checkcode
	 * @return
	 */
	List<Checkcode> listCheckcode(Checkcode checkcode);

	/**
	 * 根据条件查询，返回一个对象
	 * 
	 * @param checkcode
	 * @return
	 */
	Checkcode detailCheckcode(Checkcode checkcode);

	/**
	 * 根据条件统计记录数
	 * 
	 * @param checkcode
	 * @return
	 */
	int countCheckcode(Checkcode checkcode);
}