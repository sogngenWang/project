package com.dream.weddingexpo.action;

import org.springframework.context.annotation.Scope;

import com.dream.weddingexpo.bean.User;
import com.dream.weddingexpo.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
public class UserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
