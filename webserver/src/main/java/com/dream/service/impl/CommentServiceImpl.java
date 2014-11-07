package com.dream.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.basebean.PageBase;
import com.dream.bean.Comment;
import com.dream.bean.Praise;
import com.dream.constants.Constant;
import com.dream.dao.CommentMapper;
import com.dream.dao.PraiseMapper;
import com.dream.service.CommentService;
import com.dream.utils.CommonUtils;

@Repository(value = "commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentDao;
	@Autowired
	private PraiseMapper praiseDao;

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

	@Override
	public int countComment(Comment comment) {

		return commentDao.countComment(comment);

	}


	@Override
	public List<Comment> listCommentAndPraise(Comment comment, PageBase pageBase) {
		List<?> commentList = commentDao.listComment(comment);
		commentList = CommonUtils.createListPage(commentList, pageBase);
		List<Comment> returnCommentList = new ArrayList<Comment>();
		for (Object objTmp : commentList) {
			//判断每个comment
			Comment commentTmp = ((Comment)objTmp);
			// 判断每个评论的点赞数
			Praise praise = new Praise();
			praise.setPraisetype(Constant.PRAISE_TYPE_COMMENT);
			praise.setOtherid(commentTmp.getCommentid());
			commentTmp.setPraisecount(praiseDao.countPraise(praise));
			praise.setUserid(comment.getUserid());
			if(null == praiseDao.detailPraise(praise)){
				//如果点赞为空，则说明还未点赞
				commentTmp.setIspraise(Constant.COMMENT_NOT_PRAISE);
			}else{
				//如果点赞不为空，则说明已经点赞
				commentTmp.setIspraise(Constant.COMMENT_HAS_PRAISE);
			}
			//清理掉无关的
			commentTmp.setUserid(null); 
			returnCommentList.add(commentTmp);			
		}
		return returnCommentList;
	}

}
