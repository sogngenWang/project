package com.baidu.dao;

import com.baidu.model.test;

public interface testMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated Wed May 07 18:48:46 CST 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated Wed May 07 18:48:46 CST 2014
     */
    int insert(test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated Wed May 07 18:48:46 CST 2014
     */
    int insertSelective(test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated Wed May 07 18:48:46 CST 2014
     */
    test selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated Wed May 07 18:48:46 CST 2014
     */
    int updateByPrimaryKeySelective(test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated Wed May 07 18:48:46 CST 2014
     */
    int updateByPrimaryKey(test record);
}