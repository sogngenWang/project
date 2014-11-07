package com.dream.dao;

import java.util.List;

import com.dream.bean.Message;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageid);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer messageid);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);
 // ******************add by wsg**********************

 	/**
 	 * 根据条件查询，返回一个list
 	 * 
 	 * @param message
 	 * @return
 	 */
 	List<Message> listMessage(Message message);

 	/**
 	 * 根据条件查询，返回一个对象
 	 * 
 	 * @param message
 	 * @return
 	 */
 	Message detailMessage(Message message);
 	
 	/**
 	 * 根据条件统计记录数
 	 * @param message
 	 * @return
 	 */
 	int countMessage(Message message);
}