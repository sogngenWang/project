package com.dream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

	@RequestMapping(value = "/testController", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String controlMethod(String requestData) throws Exception {
		
		System.out.println(requestData);
		
		return "head={\"brand\":\"Lenovo\",\"imei\":\"862321022176017\",\"imsi\":\"1234567890ABCDEF\",\"model\":\"Lenovo S960\",\"netype\":\"NETWORK_TYPE_WIFI\",\"release\":\"4.4.2\",\"sdk\":\"19\",\"serial\":\"TOV8Y5FQCAS8US6L\",\"time\":\"2014-10-21 15:42:25,635\",\"versionCode\":\"1\",\"versionName\":\"com.baidu.ijoin\"}&body=423B40FFFFFFA7FFFFFFD6FFFFFF90FFFFFFB6FFFFFF87FFFFFFB36861FFFFFF98FFFFFFBC11FFFFFFA3FFFFFFF0&mac=62A151B1993791FC";
	}

}
