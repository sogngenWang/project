package com.dream.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.bean.JsonClazz;
import com.dream.bean.User;
import com.dream.constants.Constant;
import com.dream.service.UserService;
import com.dream.utils.CommonUtils;

@Controller
public class UserController {

	@Resource(name = "jsonClazz")
	private JsonClazz jsonClazz;
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value = "/detailUser")
	@ResponseBody
	public JsonClazz detailUser(User user) throws Exception {
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_OBJ,userService.detailUser(user));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}
	
	@RequestMapping(value = "/listUser")
	@ResponseBody
	public JsonClazz listUser(User user)throws Exception{
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_LIST,userService.listUser(user));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}
	
	@RequestMapping(value = "/updateUser")
	@ResponseBody
	public JsonClazz updateUser(User user)throws Exception{
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_OBJ,userService.updateUser(user));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	@RequestMapping(value = "/addUser")
	@ResponseBody
	public JsonClazz addUser(User user)throws Exception{
		jsonClazz.getData().clear();
		userService.addUser(user);
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	
	@RequestMapping(value = "/deleteUser")
	@ResponseBody
	public JsonClazz deleteUser(User user)throws Exception{
		jsonClazz.getData().clear();
		userService.deleteUser(user.getUserid());
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public JsonClazz loginUser(User user, HttpSession session) throws Exception {
		jsonClazz.getData().clear();
		if(userService.login(user)){
			jsonClazz.setState(Constant.SUCCESS);
			jsonClazz.setCode(Constant.SUCCESS_CODE);
			//把用户登录信息通过DES加密后放入session中
			session.setAttribute(Constant.SESSION_USER_INFO, CommonUtils.getEncodeStr(user.getUsername()));
		}else{
			jsonClazz.setState(Constant.FAILED);
			jsonClazz.setCode(Constant.FAILED_CODE);
		}
		
		return jsonClazz;
	}

	@RequestMapping(value = "/register")
	@ResponseBody
	public JsonClazz registerUser(User user) throws Exception {
		jsonClazz.getData().clear();
		if(userService.register(user)) {
			jsonClazz.setState(Constant.SUCCESS);
			jsonClazz.setCode(Constant.SUCCESS_CODE);
		}
		return jsonClazz;
	}
	
	@RequestMapping(value = "/logout")
	@ResponseBody
	public JsonClazz logout(User user, HttpSession session) throws Exception {
		jsonClazz.getData().clear();
//		CommonUtils.isValidUser((String)session.getAttribute(Constant.SESSION_USER_INFO)
		
		//设置session失效 TODO
		session.invalidate();
		return jsonClazz;
	}
	
}
