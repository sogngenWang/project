package com.dreamheaven.action;


import com.dreamheaven.domain.UserTmp;
import com.dreamheaven.service.UserTmpService;
import com.opensymphony.xwork2.ActionSupport;

public class UserTmpAction extends ActionSupport {

	private static final long serialVersionUID = -4284312555998190681L;
	private UserTmp userTmp;
	private UserTmpService userTmpService;
	public UserTmp getUserTmp() {
		return userTmp;
	}
	public void setUserTmp(UserTmp userTmp) {
		this.userTmp = userTmp;
	}
	public UserTmpService getUserTmpService() {
		return userTmpService;
	}
	public void setUserTmpService(UserTmpService userTmpService) {
		this.userTmpService = userTmpService;
	}	
	
	public String test(){
		userTmp.setUid(""+System.currentTimeMillis());
		userTmp.setUserSessionId("1");
		userTmpService.createUserTmp(userTmp);
		System.out.println("create success...");
		userTmp.setUserSessionId("xxxx");
		userTmpService.updateUserTmp(userTmp);
		System.out.println("update success...");
		userTmp.setUid("111");
		userTmpService.updateUserTmp(userTmp);
		System.out.println("update success...");
		return null;
	}
	
	
	

}
