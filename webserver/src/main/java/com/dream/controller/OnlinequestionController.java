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
import com.dream.bean.Onlinequestion;
import com.dream.constants.Constant;
import com.dream.service.OnlinequestionService;
import com.dream.utils.CommonUtils;
import com.google.gson.Gson;

@Controller
public class OnlinequestionController {

	public static final Log LOG = LogFactory.getLog(OnlinequestionController.class);
	private ResponseBean responseBean = new ResponseBean();
	private Gson gson = new Gson();
	private RequestBean requestBean;
	private Map<String, Object> content;

	@Resource(name = "onlinequestionService")
	private OnlinequestionService onlinequestionService;

	@RequestMapping(value = "/addOnlinequestion", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean addOnlinequestion(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Onlinequestion onlinequestion = gson.fromJson(content.toString(), Onlinequestion.class);
				CommonUtils.decriptObject(onlinequestion, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				onlinequestionService.addOnlinequestion(onlinequestion);
			} catch (Exception e) {
				LOG.error("业务执行异常...." + e.getMessage());
				responseBean.getMsg().setCode("0001");
				responseBean.getMsg().setDesc(Constant.CODE_0001);
				return responseBean;
			}
			LOG.info("业务执行成功，设置返回报文状态为成功...");
			responseBean.getMsg().setCode("0000");
			responseBean.getMsg().setDesc("成功");
			responseBean.setMac(requestBean.getHead().getSerial());
		}
		LOG.info("返回报文是:"+gson.toJson(responseBean));
		return responseBean;
	}

	@RequestMapping(value = "/listOnlinequestion", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean listOnlinequestion(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Onlinequestion onlinequestion = gson.fromJson(content.toString(), Onlinequestion.class);
				CommonUtils.decriptObject(onlinequestion, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				PageBase pageBase = CommonUtils.createNewPageBase(onlinequestion);
				List<Onlinequestion> onlinequestionList = onlinequestionService.listOnlinequestion(onlinequestion);
				responseBean.setContent(CommonUtils.createListPage(onlinequestionList , pageBase));
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

}
