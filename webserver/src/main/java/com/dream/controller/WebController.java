package com.dream.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.security.TDESUtils;
import com.dream.bean.MsgResponse;
import com.dream.bean.RequestDatagram;
import com.dream.bean.ResponseDatagram;
import com.dream.bean.User;
import com.google.gson.Gson;


@Controller
public class WebController{
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/testController", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public ResponseDatagram testController(String request) throws Exception {
		ResponseDatagram responseDatagram = new ResponseDatagram();
		Gson gson = new Gson();
		RequestDatagram requestDatagram = gson.fromJson(request, RequestDatagram.class);
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
			
			MsgResponse msgResponse = new MsgResponse();
			msgResponse.setTime((new Date()).toString());
			msgResponse.setCode("0000");
			msgResponse.setType("0");
			responseDatagram.setMsg(msgResponse);
			responseDatagram.setContent(user);
			responseDatagram.setMac(newMac);
			
		}
		
		return responseDatagram;
	}
	
	
}