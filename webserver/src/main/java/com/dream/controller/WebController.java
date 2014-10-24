package com.dream.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.security.TDESUtils;
import com.dream.bean.TmpMsgResponse;
import com.dream.bean.RequestBean;
import com.dream.bean.ResponseBean;
import com.dream.bean.TmpResponseDatagram;
import com.dream.bean.TmpRequestDatagram;
import com.dream.bean.User;
import com.google.gson.Gson;


@Controller
public class WebController{
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/testController", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public TmpResponseDatagram testController(String request) throws Exception {
		TmpResponseDatagram responseDatagram = new TmpResponseDatagram();
		Gson gson = new Gson();
		TmpRequestDatagram requestDatagram = gson.fromJson(request, TmpRequestDatagram.class);
		Map<String,String> map = (Map<String,String>) requestDatagram.getContent();
		User user = gson.fromJson(requestDatagram.getContent().toString(), User.class);
		//进行校验
		String verifyCode = TDESUtils.MAC_ECB(gson.toJson(user), requestDatagram.getHead().getSerial());
		if(verifyCode.equals( requestDatagram.getMac())){
			System.out.println("校验成功....");
			String username = TDESUtils.decrypt(map.get("username"), requestDatagram.getHead().getImei());
			String job = TDESUtils.decrypt(map.get("job"), requestDatagram.getHead().getImsi());
			System.out.println("job="+job + "|||username="+username);
			
			user.setUsername(TDESUtils.encrypt("you say your username is "+username,requestDatagram.getHead().getImei()));
			user.setJob(TDESUtils.encrypt("you say your job is "+job,requestDatagram.getHead().getImsi()));
			
			String newUser = gson.toJson(user);
			String newMac = TDESUtils.MAC_ECB(newUser, requestDatagram.getHead().getSerial() );
			
			TmpMsgResponse msgResponse = new TmpMsgResponse();
			msgResponse.setTime((new Date()).toString());
			msgResponse.setCode("0000");
			msgResponse.setType("0");
			responseDatagram.setMsg(msgResponse);
			responseDatagram.setContent(user);
			responseDatagram.setMac(newMac);
			
		}
		
		return responseDatagram;
	}
	
	
	@RequestMapping(value = "/testController1", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ResponseBean testController1(String request) throws Exception {
		ResponseBean responseBean = new ResponseBean();
		Gson gson = new Gson();
		RequestBean requestBean = gson.fromJson(request, RequestBean.class);
		Map<String,String> map =  requestBean.getContent();
		
		User user = gson.fromJson(requestBean.getContent().toString(), User.class);
		//进行校验
		if(requestBean.checkMac(requestBean.getHead().getSerial())){
			System.out.println("校验成功....");
			String username = TDESUtils.decrypt(map.get("username"), requestBean.getHead().getImei());
			String job = TDESUtils.decrypt(map.get("job"), requestBean.getHead().getImsi());
			System.out.println("job="+job + "|||username="+username);
			
			user.setUsername(TDESUtils.encrypt("you say your username is "+username,requestBean.getHead().getImei()));
			user.setJob(TDESUtils.encrypt("you say your job is "+job,requestBean.getHead().getImsi()));
			
//			responseBean.setMsgCode("0000");
//			responseBean.setMsgDesc("成功");
//			responseBean.addParams("username", user.getUsername());
//			responseBean.addParams("job", user.getJob());
			responseBean.setMac(requestBean.getHead().getSerial());

		}
		
		return responseBean;
	}
	
	
}