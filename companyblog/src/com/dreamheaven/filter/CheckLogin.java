package com.dreamheaven.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dreamheaven.common.utils.CommonUtils;

public class CheckLogin implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if (null == CommonUtils.getUserFromSession() 
				|| null == CommonUtils.getUserFromSession().getUid()
				|| "".equals(CommonUtils.getUserFromSession().getUid())) 
		{
			httpResponse.sendRedirect("/login.jsp");
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
