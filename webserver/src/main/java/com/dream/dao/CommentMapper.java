package com.dream.dao;

import java.util.List;

import com.dream.bean.Comment;

public interface CommentMapper {

    int deleteByPrimaryKey(Integer commentid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
    
    
	// ******************add by wsg**********************

	/**
	 * 根据条件查询，返回一个list
	 * 
	 * @param comment
	 * @return
	 */
	List<Comment> listComment(Comment comment);

	/**
	 * 根据条件查询，返回一个对象
	 * 
	 * @param comment
	 * @return
	 */
	Comment detailComment(Comment comment);
	
	/**
	 * 根据条件统计记录数
	 * @param comment
	 * @return
	 */
	int countComment(Comment comment);
}