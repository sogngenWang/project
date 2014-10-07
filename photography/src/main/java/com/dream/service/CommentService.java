package com.dream.service;

import java.util.List;

import com.dream.bean.Comment;

public interface CommentService {

	Comment detailComment(Comment comment);

	List<Comment> listComment(Comment comment);

	int updateComment(Comment comment);

	int addComment(Comment comment);

	int deleteComment(int commentid);
}
