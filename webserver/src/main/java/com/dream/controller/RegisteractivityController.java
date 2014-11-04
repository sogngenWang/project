package com.dream.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.basebean.PageBase;
import com.dream.basebean.RequestBean;
import com.dream.basebean.ResponseBean;
import com.dream.bean.Registeractivity;
import com.dream.bean.User;
import com.dream.constants.Constant;
import com.dream.service.RegisteractivityService;
import com.dream.utils.CommonUtils;
import com.google.gson.Gson;

@Controller
public class RegisteractivityController {

	public static final Log LOG = LogFactory.getLog(RegisteractivityController.class);
	private ResponseBean responseBean = new ResponseBean();
	private Gson gson = new Gson();
	private RequestBean requestBean;
	private Map<String, Object> content;

	@Resource(name = "registeractivityService")
	private RegisteractivityService registeractivityService;


	@RequestMapping(value = "/listRegisterSignUser", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean listRegisterSignUser(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Registeractivity  registeractivity = gson.fromJson(content.toString(), Registeractivity.class);
				CommonUtils.decriptObject(registeractivity, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				if(!registeractivityService.isUserSign(registeractivity)){
					//如果用户还为签到，则抛出异常
					LOG.error("用户还未签到，列出已签到用户失败...." );
					responseBean.getMsg().setCode("0006");
					responseBean.getMsg().setDesc(Constant.CODE_0006);
					return responseBean;
				}
				PageBase pageBase = CommonUtils.createNewPageBase(registeractivity);
				List<User> userList = registeractivityService.listRegisterSignUser(registeractivity);
				responseBean.setContent(CommonUtils.createListPage(userList , pageBase));
				responseBean.setContent(pageBase);
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("业务执行异常...." + e.getMessage());
				responseBean.getMsg().setCode("0001");
				responseBean.getMsg().setDesc("业务异常");
				return responseBean;
			}
			LOG.info("业务执行成功，设置返回报文状态为成功...");
			responseBean.getMsg().setCode("0000");
			responseBean.getMsg().setDesc("成功");
			responseBean.setMac(requestBean.getHead().getSerial());
		}

		return responseBean;
	}

	@RequestMapping(value = "/countRegisterSign", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean countRegisterSign(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Registeractivity  registeractivity = gson.fromJson(content.toString(), Registeractivity.class);
				CommonUtils.decriptObject(registeractivity, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				int signcount =  registeractivityService.countRegisterSign(registeractivity);
				registeractivity = new Registeractivity();
				registeractivity.setSigncount(signcount);
				responseBean.setContent(registeractivity);
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("业务执行异常...." + e.getMessage());
				responseBean.getMsg().setCode("0001");
				responseBean.getMsg().setDesc("业务异常");
				return responseBean;
			}
			LOG.info("业务执行成功，设置返回报文状态为成功...");
			responseBean.getMsg().setCode("0000");
			responseBean.getMsg().setDesc("成功");
			responseBean.setMac(requestBean.getHead().getSerial());
		}

		return responseBean;
	}

}
