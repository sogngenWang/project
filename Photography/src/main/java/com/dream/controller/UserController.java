package com.dream.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.dream.bean.User;
import com.dream.service.UserService;

@Controller
public class UserController {

	@Resource(name = "user")
	private User user;
	@Resource(name = "userService")
	private UserService userService;
}
