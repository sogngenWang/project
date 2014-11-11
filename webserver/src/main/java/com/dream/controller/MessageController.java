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

import com.dream.annotation.RequestNeedParam;
import com.dream.basebean.PageBase;
import com.dream.basebean.RequestBean;
import com.dream.basebean.ResponseBean;
import com.dream.bean.Message;
import com.dream.constants.Constant;
import com.dream.service.MessageService;
import com.dream.utils.CommonUtils;
import com.google.gson.Gson;

@Controller
public class MessageController {

	public static final Log LOG = LogFactory.getLog(MessageController.class);
	private ResponseBean responseBean = new ResponseBean();
	private Gson gson = new Gson();
	private RequestBean requestBean;
	private Map<String, Object> content;

	@Resource(name = "messageService")
	private MessageService messageService;

	@RequestNeedParam({"currentPage","isread","userid"})
	@RequestMapping(value = "/listMessage", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean listMessage(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Message message = gson.fromJson(content.toString(), Message.class);
				CommonUtils.decriptObject(message, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				PageBase pageBase = CommonUtils.createNewPageBase(message);
				//根据选择的类型，如果不填，则返回该用户的所有消息，如果有值，则返回该用户的未读消息
				List<Message> messageList = messageService.listMessage(message);
				responseBean.setContent(CommonUtils.createListPage(messageList, pageBase));
				responseBean.setContent(pageBase);
				
			} catch (Exception e) {
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

	@RequestNeedParam({"messageid"})
	@RequestMapping(value = "/detailMessage", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean detailMessage(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Message message = gson.fromJson(content.toString(), Message.class);
				CommonUtils.decriptObject(message, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				message = messageService.detailAndSetreadMessage(message);
				responseBean.setContent(message);
			} catch (Exception e) {
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
