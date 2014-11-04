package com.dream.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.basebean.RequestBean;
import com.dream.basebean.ResponseBean;
import com.dream.bean.Checkcode;
import com.dream.constants.Constant;
import com.dream.service.CheckcodeService;
import com.dream.utils.CommonUtils;
import com.google.gson.Gson;

@Controller
public class CheckcodeController {

	public static final Log LOG = LogFactory.getLog(CheckcodeController.class);
	private ResponseBean responseBean = new ResponseBean();
	private Gson gson = new Gson();
	private RequestBean requestBean;
	private Map<String, Object> content;

	@Resource(name = "checkcodeService")
	private CheckcodeService checkcodeService;


	@RequestMapping(value = "/generateCheckcode", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean generateCheckcode(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Checkcode checkcode = gson.fromJson(content.toString(), Checkcode.class);
				CommonUtils.decriptObject(checkcode, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				// 把该娇艳存入到数据库中
				String checkcodeString = checkcodeService.addCheckcodeAndSendMobile(checkcode.getTelephone());
				checkcode = new Checkcode();
				checkcode.setCheckcode(checkcodeString);
				responseBean.setContent(checkcode);
			} catch (Exception e) {
				e.printStackTrace();
				LOG.error("业务执行异常...." + e.getMessage());
				responseBean.getMsg().setCode("0001");
				responseBean.getMsg().setDesc(Constant.CODE_0001);
				return responseBean;
			}
			LOG.info("业务执行成功，设置返回报文状态为成功...");
			responseBean.getMsg().setCode("0000");
			responseBean.getMsg().setDesc(Constant.CODE_0000);
			responseBean.setMac(requestBean.getHead().getSerial());
		}

		return responseBean;
	}

}
