package com.dreamheaven.action;


import org.apache.commons.lang.StringUtils;

import com.dreamheaven.domain.User;
import com.dreamheaven.domain.UserTmp;
import com.dreamheaven.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = -8969362068004703309L;
	private User user;
	private UserTmp userTmp;
	private UserService userService;	
	
	public UserTmp getUserTmp() {
		return userTmp;
	}

	public void setUserTmp(UserTmp userTmp) {
		this.userTmp = userTmp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 通过传入的登录用户名，密码，去尝试登录，如果登录成功，则返回一个唯一的sessionId，否则，返回null
	public String login() {
		user.setErrorInfo(null);
		if(StringUtils.isBlank(userService.login(user))){
			return "success";
		}else{
			user.setErrorInfo("login error...please reconfirm your username/password...");
			return "failed";
		}
	}
	
	public String logout() {
		if(userService.logout(userTmp)){
			return "success";
		}else{
			return "failed";
		}
	}

}
