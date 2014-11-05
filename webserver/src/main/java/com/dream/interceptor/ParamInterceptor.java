package com.dream.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dream.annotation.RequestNeedParam;
import com.dream.controller.OnlinequestionController;

public class ParamInterceptor implements HandlerInterceptor {

	public static final Log LOG = LogFactory.getLog(ParamInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//获取request请求
		String requestStr = request.getParameter("request");
		String methodName = request.getRequestURL().substring(request.getRequestURL().lastIndexOf("/")+1);
		Method m = OnlinequestionController.class.getMethod(methodName,String.class);
		RequestNeedParam requestNeedParam = m.getAnnotation(RequestNeedParam.class);
		String[]  params = requestNeedParam.value();
		
		for (String param : params) {
			if(!requestStr.contains(param)){
				LOG.error("param doesn's include in request param ....");
				LOG.error("requestStr = " + requestStr );
				LOG.error("need include params = " + Arrays.toString(params) );
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
}
