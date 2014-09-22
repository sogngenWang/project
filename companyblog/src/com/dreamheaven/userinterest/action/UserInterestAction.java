package com.dreamheaven.userinterest.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.dreamheaven.common.utils.CommonUtils;
import com.dreamheaven.userinterest.domain.UserInterest;
import com.dreamheaven.userinterest.domain.UserInterestPK;
import com.dreamheaven.userinterest.service.UserInterestService;
import com.opensymphony.xwork2.ActionSupport;

public class UserInterestAction extends ActionSupport {
	
	private static final long serialVersionUID = 244335734125947860L;

	private String listenedId;
	
	private UserInterestService userInterestService;
	
	public UserInterestService getUserInterestService() {
		return userInterestService;
	}

	public void setUserInterestService(UserInterestService userInterestService) {
		this.userInterestService = userInterestService;
	}

	public String getListenedId() {
		return listenedId;
	}

	public void setListenedId(String listenedId) {
		this.listenedId = listenedId;
	}

	@Override
	public String execute() throws Exception {

		return null;
	}
	
	public String countFans()
	{
		
			UserInterest userInterest = new UserInterest();
			UserInterestPK userInterestPK = new UserInterestPK();
			userInterestPK.setListenedId(CommonUtils.getUserFromSession().getUid());
			userInterest.setUserInterestPK(userInterestPK);
			
			int count = userInterestService.countFans(userInterest);
			JSONObject json = new JSONObject();
			json.put("fansCount", count);
			json.put("isSuccess", true);
			CommonUtils.generateJson(json);
		
		return null;
	}
	
	public String countAttention()
	{
		try
		{
			
			UserInterest userInterest = new UserInterest();
			UserInterestPK userInterestPK = new UserInterestPK();
			userInterestPK.setUid(CommonUtils.getUserFromSession().getUid());
			userInterest.setUserInterestPK(userInterestPK);

			int count = userInterestService.countAttention(userInterest);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html; charset=utf-8");
			JSONObject obj = new JSONObject();
			obj.put("attentionCount", count);
			obj.put("isSuccess", true);
			PrintWriter out = response.getWriter();
			out.println(obj);
			out.flush();
			out.close();

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String addListenUser()
	{
		UserInterest userInterest = new UserInterest();
		UserInterestPK userInterestPK = new UserInterestPK();
		userInterestPK.setUid(CommonUtils.getUserFromSession().getUid());
		userInterestPK.setListenedId(listenedId);
		
		userInterest.setUserInterestPK(userInterestPK);
		
		userInterestService.createListenByUid(userInterest);
		
		return SUCCESS;
	}
	
	public String deleteListenUser()
	{
		UserInterest userInterest = new UserInterest();
		UserInterestPK userInterestPK = new UserInterestPK();
		userInterestPK.setUid(CommonUtils.getUserFromSession().getUid());
		userInterestPK.setListenedId(listenedId);
		
		userInterest.setUserInterestPK(userInterestPK);
		
		userInterestService.deleteListenByUid(userInterest);
		
		return SUCCESS;
	}

}
