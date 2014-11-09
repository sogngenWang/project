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
import com.dream.bean.Activity;
import com.dream.bean.Friends;
import com.dream.bean.User;
import com.dream.constants.Constant;
import com.dream.service.FriendsService;
import com.dream.utils.CommonUtils;
import com.google.gson.Gson;

@Controller
public class FriendsController {

	public static final Log LOG = LogFactory.getLog(FriendsController.class);
	private ResponseBean responseBean = new ResponseBean();
	private Gson gson = new Gson();
	private RequestBean requestBean;
	private Map<String, Object> content;

	@Resource(name = "friendsService")
	private FriendsService friendsService;

	

	@RequestNeedParam({"userid","currentPage"})
	@RequestMapping(value = "/listFriendsSendMessage", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean listFriendsSendMessage(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Friends friends = gson.fromJson(content.toString(), Friends.class);
				CommonUtils.decriptObject(friends, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				PageBase pageBase = CommonUtils.createNewPageBase(friends);
				//根据选择的类型，如果不填，则返回该用户的所有消息，如果有值，则返回该用户的未读消息
				List<Friends> friendsList = friendsService.listSendFriends(friends,pageBase);
				responseBean.setContent(friendsList);
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


	@RequestNeedParam({"frienduserid","currentPage"})
	@RequestMapping(value = "/listFriendsReceiveMessage", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean listFriendsReceiveMessage(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Friends friends = gson.fromJson(content.toString(), Friends.class);
				CommonUtils.decriptObject(friends, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				PageBase pageBase = CommonUtils.createNewPageBase(friends);
				//根据选择的类型，如果不填，则返回该用户的所有消息，如果有值，则返回该用户的未读消息
				List<Friends> friendsList = friendsService.listReceiveFriends(friends,pageBase);
				responseBean.setContent(friendsList);
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
	
	@RequestNeedParam({"userid","friendsid"})
	@RequestMapping(value = "/addANewFriends", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean detailFriends(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Friends friends = gson.fromJson(content.toString(), Friends.class);
				CommonUtils.decriptObject(friends, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				Activity activity = friendsService.addANewFriends(friends);
				responseBean.setContent(activity);
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
	
	

	@RequestNeedParam({"userid","friendsid"})
	@RequestMapping(value = "/manageFriendsAdd", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean manageFriendsAdd(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Friends friends = gson.fromJson(content.toString(), Friends.class);
				CommonUtils.decriptObject(friends, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				friendsService.manageFriendsAdd(friends);
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
	
	@RequestNeedParam({"currentPage","userid"})
	@RequestMapping(value = "/listFriends", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean listFriends(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Friends friends = gson.fromJson(content.toString(), Friends.class);
				CommonUtils.decriptObject(friends, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				PageBase pageBase = CommonUtils.createNewPageBase(friends);
				//根据选择的类型，如果不填，则返回该用户的所有消息，如果有值，则返回该用户的未读消息
				List<User> friendsList = friendsService.listAllFriends(friends,pageBase); 
				responseBean.setContent(friendsList);
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

	
	
//	@RequestNeedParam({"friendsid"})
//	@RequestMapping(value = "/detailFriends", method = { RequestMethod.POST })
//	@ResponseBody
//	public ResponseBean detailFriends(String request) {
//		requestBean = gson.fromJson(request, RequestBean.class);
//		// 进行校验
//		if (requestBean.checkMac()) {
//			LOG.info("校验成功....");
//			// 真正的业务逻辑
//			try {
//				content = requestBean.getContent();
//				Friends friends = gson.fromJson(content.toString(), Friends.class);
//				CommonUtils.decriptObject(friends, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
//				friends = friendsService.detailFriends(friends);
//				responseBean.setContent(friends);
//			} catch (Exception e) {
//				LOG.error("业务执行异常...." + e.getMessage());
//				responseBean.getMsg().setCode("0001");
//				responseBean.getMsg().setDesc(Constant.CODE_0001);
//				return responseBean;
//			}
//			LOG.info("业务执行成功，设置返回报文状态为成功...");
//			responseBean.getMsg().setCode("0000");
//			responseBean.getMsg().setDesc(Constant.CODE_0000);
//			responseBean.setMac(requestBean.getHead().getSerial());
//		}
//
//		return responseBean;
//	}
}
