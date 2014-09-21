package com.dream.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dream.bean.User;

@Controller
public class LoginController {
	
    @RequestMapping(value="login")
    public ModelAndView login(HttpServletRequest request,HttpServletResponse response,User user ){
        String username = user.getUsername();
        ModelAndView mv = new ModelAndView("src/main/index","command","LOGIN SUCCESS, " + username);
        return mv;
    }
    
    
    
    
}