package com.dream.bean;

import com.dream.basebean.PageBase;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Comment extends PageBase {
	// ************
	// 评论总的点赞数量
	private Integer praisecount;
	// 0 表示还未点赞，1 表示已经点赞
	private Integer ispraise;

	public Integer getIspraise() {
		return ispraise;
	}

	public void setIspraise(Integer ispraise) {
		this.ispraise = ispraise;
	}

	public Integer getPraisecount() {
		return praisecount;
	}

	public void setPraisecount(Integer praisecount) {
		this.praisecount = praisecount;
	}

	private Integer commentid;

	private Integer userid;

	private Integer themeid;

	private Integer commentseq;

	private String commenttime;

	private String commentcontent;

	public Integer getCommentid() {
		return commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getThemeid() {
		return themeid;
	}

	public void setThemeid(Integer themeid) {
		this.themeid = themeid;
	}

	public Integer getCommentseq() {
		return commentseq;
	}

	public void setCommentseq(Integer commentseq) {
		this.commentseq = commentseq;
	}

	public String getCommenttime() {
		return commenttime;
	}

	public void setCommenttime(String commenttime) {
		this.commenttime = commenttime;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

}