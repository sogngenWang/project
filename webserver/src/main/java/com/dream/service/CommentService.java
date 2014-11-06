package com.dream.service;

import java.util.List;

import com.dream.basebean.PageBase;
import com.dream.bean.Comment;

public interface CommentService {

	List<Comment> listComment(Comment comment);
	
	Comment detailComment(Comment comment);

	int updateComment(Comment comment);
	
	int deleteComment(int uid);
	
	int addComment(Comment comment);

	int countComment(Comment comment);

	List<Comment> listCommentAndPraise(Comment comment, PageBase pageBase);
}
