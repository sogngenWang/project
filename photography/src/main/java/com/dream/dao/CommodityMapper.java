package com.dream.dao;

import java.util.List;

import com.dream.bean.Commodity;

public interface CommodityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbggenerated Fri Oct 03 14:52:46 CST 2014
     */
    int deleteByPrimaryKey(Integer commodityid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbggenerated Fri Oct 03 14:52:46 CST 2014
     */
    int insert(Commodity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbggenerated Fri Oct 03 14:52:46 CST 2014
     */
    int insertSelective(Commodity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbggenerated Fri Oct 03 14:52:46 CST 2014
     */
    Commodity selectByPrimaryKey(Integer commodityid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbggenerated Fri Oct 03 14:52:46 CST 2014
     */
    int updateByPrimaryKeySelective(Commodity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table commodity
     *
     * @mbggenerated Fri Oct 03 14:52:46 CST 2014
     */
    int updateByPrimaryKey(Commodity record);



    
	
	// ******************add by wsg**********************
	/**
	 * 根据条件返回一个对象
	 * 
	 * @param commodity
	 * @return
	 */
	Commodity detailCommodity(Commodity commodity);

	/**
	 * 根据条件返回一个list
	 * 
	 * @param commodity
	 * @return
	 */
	List<Commodity> listCommodity(Commodity commodity);

}