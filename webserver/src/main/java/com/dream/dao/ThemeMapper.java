package com.dream.dao;

import java.util.List;

import com.dream.bean.Theme;

public interface ThemeMapper {

    int deleteByPrimaryKey(Integer themeid);

    int insert(Theme record);

    int insertSelective(Theme record);

    Theme selectByPrimaryKey(Integer themeid);

    int updateByPrimaryKeySelective(Theme record);

    int updateByPrimaryKey(Theme record);

    
	// ******************add by wsg**********************

	/**
	 * 根据条件查询，返回一个list
	 * 
	 * @param theme
	 * @return
	 */
	List<Theme> listTheme(Theme theme);

	/**
	 * 根据条件查询，返回一个对象
	 * 
	 * @param theme
	 * @return
	 */
	Theme detailTheme(Theme theme);
	
	/**
	 * 根据条件统计记录数
	 * @param theme
	 * @return
	 */
	int countTheme(Theme theme);
}