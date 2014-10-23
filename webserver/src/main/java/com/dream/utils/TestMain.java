package com.dream.utils;

import java.util.Date;
import java.util.Map;

import com.baidu.security.TDESUtils;
import com.dream.bean.MsgResponse;
import com.dream.bean.RequestDatagram;
import com.dream.bean.ResponseDatagram;
import com.dream.bean.User;
import com.dream.controller.WebController;
import com.google.gson.Gson;

public class TestMain {
	public static void main(String[] args) throws Exception {
		String response = "{\"msg\":{\"time\":\"Thu Oct 23 11:51:28 CST 2014\",\"code\":\"0\",\"type\":\"0\"},\"content\":{\"job\":\"FFFFFF806CFFFFFF8DFFFFFF9235FFFFFF8C05565956FFFFFFC4FFFFFFA1FFFFFFA3FFFFFFC70FFFFFFFC6FFFFFFA76C26FFFFFFDA065EFFFFFFD4FFFFFFA9\",\"username\":\"6FFFFFFFF2FFFFFF941C6FFFFFFF9D172EFFFFFFB351152D78366255FFFFFFA6042BFFFFFFE126FFFFFFBC000FFFFFFFE0FFFFFFB0FFFFFFDD64FFFFFF9F444BFFFFFFDF\"},\"mac\":\"83E6A5FB5E6393AD\"}";
		String request = "{\"head\":{\"brand\":\"Lenovo\",\"imei\":\"862321022176017\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Lenovo S960\",\"netype\":\"NETWORK_TYPE_WIFI\",\"release\":\"4.4.2\",\"sdk\":\"19\",\"serial\":\"TOV8Y5FQCAS8US6L\",\"time\":\"2014-10-22 10:01:46,462\",\"versionCode\":\"1\",\"versionName\":\"1.0\"},\"content\":{\"job\":\"FFFFFFB263FFFFFFD410FFFFFFE2FFFFFFC0FFFFFFE42A\",\"username\":\"1E1147FFFFFFA4FFFFFFDDFFFFFF9D31FFFFFFA3\"},\"mac\":\"695D3C76A1708968\"}";
		ResponseDatagram responseDatagram = testController(request);
		Gson gson = new Gson();
		String jsonContent = gson.toJson(responseDatagram.getContent());
		System.out.println("content="+jsonContent);
		String checkCode = TDESUtils.MAC_ECB(jsonContent, "TOV8Y5FQCAS8US6L");
		System.out.println("checkCode="+checkCode+"|mac="+"83E6A5FB5E6393AD");
		System.out.println("username="+TDESUtils.decrypt(((User)responseDatagram.getContent()).getUsername(),"862321022176017"));
		System.out.println("job="+TDESUtils.decrypt(((User)responseDatagram.getContent()).getJob(),"1234567890ABCDEF"));
		
	}
	
	
	public static ResponseDatagram testController(String request) throws Exception {
		ResponseDatagram responseDatagram = new ResponseDatagram();
		Gson gson = new Gson();
		RequestDatagram requestDatagram = gson.fromJson(request, RequestDatagram.class);
		Map<String,String> map = (Map<String,String>) requestDatagram.getContent();
		
//		String tmp = "{\"job\":\"FFFFFFB263FFFFFFD410FFFFFFE2FFFFFFC0FFFFFFE42A\",\"username\":\"1E1147FFFFFFA4FFFFFFDDFFFFFF9D31FFFFFFA3\"}";
		
		User user = new User();
		user.setUsername(map.get("username"));
		user.setJob(map.get("job"));
		
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
			msgResponse.setCode("0");
			msgResponse.setType("0");
			responseDatagram.setMsg(msgResponse);
			responseDatagram.setContent(user);
			responseDatagram.setMac(newMac);
			
		}
		
		return responseDatagram;
	}
}
