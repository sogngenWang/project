package com.dream.dao;

import com.dream.bean.Activity;

public interface ActivityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Mon Oct 27 23:55:35 CST 2014
     */
    int deleteByPrimaryKey(Integer activityid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Mon Oct 27 23:55:35 CST 2014
     */
    int insert(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Mon Oct 27 23:55:35 CST 2014
     */
    int insertSelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Mon Oct 27 23:55:35 CST 2014
     */
    Activity selectByPrimaryKey(Integer activityid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Mon Oct 27 23:55:35 CST 2014
     */
    int updateByPrimaryKeySelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Mon Oct 27 23:55:35 CST 2014
     */
    int updateByPrimaryKey(Activity record);
}