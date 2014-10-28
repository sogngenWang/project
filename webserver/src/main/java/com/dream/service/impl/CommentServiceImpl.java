package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Comment;
import com.dream.dao.CommentMapper;
import com.dream.service.CommentService;

@Repository(value = "commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentDao;

	@Override
	public List<Comment> listComment(Comment comment) {

		return commentDao.listComment(comment);
	}

	@Override
	public Comment detailComment(Comment comment) {

		return commentDao.detailComment(comment);
	}

	@Override
	public int updateComment(Comment comment) {

		return commentDao.updateByPrimaryKeySelective(comment);
	}

	@Override
	public int deleteComment(int uid) {

		return commentDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addComment(Comment comment) {

		return commentDao.insert(comment);

	}

}
