package com.dream.basebean;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dream.controller.UserController;
import com.google.gson.Gson;

public class ControllerBase {
	protected ResponseBean responseBean = new ResponseBean();
	protected Gson gson = new Gson();
	protected RequestBean requestBean;
	protected Map<String, Object> content;
	private static final Log LOG = LogFactory.getLog(UserController.class);
	
	protected boolean before(String request){
		requestBean = gson.fromJson(request, RequestBean.class);
		boolean flag = requestBean.checkMac();
		if(flag){
			LOG.info("校验成功....");
		}
		return flag;
	}
	
	
	protected void after(){
		
	}
	
}
