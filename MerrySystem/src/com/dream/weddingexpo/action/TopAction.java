package com.dream.weddingexpo.action;

import org.springframework.context.annotation.Scope;

import com.dream.weddingexpo.bean.Top;
import com.dream.weddingexpo.service.TopService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
public class TopAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Top top;
	private TopService topService;

	public TopService getTopService() {
		return topService;
	}
	public void setTopService(TopService topService) {
		this.topService = topService;
	}
	public Top getTop() {
		return top;
	}
	public void setTop(Top top) {
		this.top = top;
	}
	
	
}
