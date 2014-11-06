package com.dream.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.annotation.RequestNeedParam;
import com.dream.basebean.RequestBean;
import com.dream.basebean.ResponseBean;
import com.dream.bean.Praise;
import com.dream.constants.Constant;
import com.dream.service.PraiseService;
import com.dream.utils.CommonUtils;
import com.google.gson.Gson;

@Controller
public class PraiseController {

	public static final Log LOG = LogFactory.getLog(PraiseController.class);
	private ResponseBean responseBean = new ResponseBean();
	private Gson gson = new Gson();
	private RequestBean requestBean;
	private Map<String, Object> content;

	@Resource(name = "praiseService")
	private PraiseService praiseService;

	/**
	 * 活动点赞
	 * @param request
	 * @return
	 */
	@RequestNeedParam({"userid","otherid"})
	@RequestMapping(value = "/addActivityPraise", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean addActivityPraise(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Praise praise = gson.fromJson(content.toString(), Praise.class);
				CommonUtils.decriptObject(praise, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				//先判断用户是否已经点赞，对于已经点赞的用户，禁止再次点赞
				praise.setPraisetype(Constant.PRAISE_TYPE_ACTIVITY);
				if(null != praiseService.detailPraise(praise)){
					responseBean.getMsg().setCode("0010");
					responseBean.getMsg().setDesc(Constant.CODE_0010);
					return responseBean;
				}
				praiseService.addPraise(praise);
				responseBean.setContent(praise);
			} catch (Exception e) {
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
		LOG.info("返回报文是:"+gson.toJson(responseBean));
		return responseBean;
	}
	
	/**
	 * 主题点赞
	 * @param request
	 * @return
	 */
	@RequestNeedParam({"userid","otherid"})
	@RequestMapping(value = "/addThemePraise", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean addThemePraise(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Praise praise = gson.fromJson(content.toString(), Praise.class);
				CommonUtils.decriptObject(praise, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				//先判断用户是否已经点赞，对于已经点赞的用户，禁止再次点赞
				praise.setPraisetype(Constant.PRAISE_TYPE_THEME);
				if(null != praiseService.detailPraise(praise)){
					responseBean.getMsg().setCode("0010");
					responseBean.getMsg().setDesc(Constant.CODE_0010);
					return responseBean;
				}
				praiseService.addPraise(praise);
				responseBean.setContent(praise);
			} catch (Exception e) {
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
		LOG.info("返回报文是:"+gson.toJson(responseBean));
		return responseBean;
	}
	

	/**
	 * 评论点赞 TODO
	 * @param request
	 * @return
	 */
	@RequestNeedParam({"userid","otherid"})
	@RequestMapping(value = "/addCommentPraise", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean addCommentPraise(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				Praise praise = gson.fromJson(content.toString(), Praise.class);
				CommonUtils.decriptObject(praise, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				//先判断用户是否已经点赞，对于已经点赞的用户，禁止再次点赞
				praise.setPraisetype(Constant.PRAISE_TYPE_COMMENT);
				if(null != praiseService.detailPraise(praise)){
					responseBean.getMsg().setCode("0010");
					responseBean.getMsg().setDesc(Constant.CODE_0010);
					return responseBean;
				}
				praiseService.addPraise(praise);
				responseBean.setContent(praise);
			} catch (Exception e) {
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
		LOG.info("返回报文是:"+gson.toJson(responseBean));
		return responseBean;
	}
	
//	@RequestMapping(value = "/detailPraise", method = { RequestMethod.POST })
//	@ResponseBody
//	public ResponseBean detailPraise(String request) {
//		requestBean = gson.fromJson(request, RequestBean.class);
//		// 进行校验
//		if (requestBean.checkMac()) {
//			LOG.info("校验成功....");
//			// 真正的业务逻辑
//			try {
//				content = requestBean.getContent();
//				Praise praise = gson.fromJson(content.toString(), Praise.class);
//				CommonUtils.decriptObject(praise, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
//				praise = praiseService.detailPraise(praise);
//				responseBean.setContent(praise);
//			} catch (Exception e) {
//				LOG.error("业务执行异常...." + e.getMessage());
//				responseBean.getMsg().setCode("0001");
//				responseBean.getMsg().setDesc("业务异常");
//				return responseBean;
//			}
//			LOG.info("业务执行成功，设置返回报文状态为成功...");
//			responseBean.getMsg().setCode("0000");
//			responseBean.getMsg().setDesc("成功");
//			responseBean.setMac(requestBean.getHead().getSerial());
//		}
//
//		return responseBean;
//	}

//	@RequestMapping(value = "/listPraise", method = { RequestMethod.POST })
//	@ResponseBody
//	public ResponseBean listPraise(String request) {
//		requestBean = gson.fromJson(request, RequestBean.class);
//		// 进行校验
//		if (requestBean.checkMac()) {
//			LOG.info("校验成功....");
//			// 真正的业务逻辑
//			try {
//				content = requestBean.getContent();
//				Praise praise = gson.fromJson(content.toString(), Praise.class);
//				CommonUtils.decriptObject(praise, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
//				List<Praise> praiseList = praiseService.listPraise(praise);
//				responseBean.setContent(praiseList);
//			} catch (Exception e) {
//				LOG.error("业务执行异常...." + e.getMessage());
//				responseBean.getMsg().setCode("0001");
//				responseBean.getMsg().setDesc("业务异常");
//				return responseBean;
//			}
//			LOG.info("业务执行成功，设置返回报文状态为成功...");
//			responseBean.getMsg().setCode("0000");
//			responseBean.getMsg().setDesc("成功");
//			responseBean.setMac(requestBean.getHead().getSerial());
//		}
//
//		return responseBean;
//	}

//	@RequestMapping(value = "/updatePraise", method = { RequestMethod.POST })
//	@ResponseBody
//	public ResponseBean updatePraise(String request) {
//		requestBean = gson.fromJson(request, RequestBean.class);
//		// 进行校验
//		if (requestBean.checkMac()) {
//			LOG.info("校验成功....");
//			// 真正的业务逻辑
//			try {
//				content = requestBean.getContent();
//				Praise praise = gson.fromJson(content.toString(), Praise.class);
//				CommonUtils.decriptObject(praise, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
//				praiseService.updatePraise(praise);
//				responseBean.setContent(praise);
//			} catch (Exception e) {
//				LOG.error("业务执行异常...." + e.getMessage());
//				responseBean.getMsg().setCode("0001");
//				responseBean.getMsg().setDesc("业务异常");
//				return responseBean;
//			}
//			LOG.info("业务执行成功，设置返回报文状态为成功...");
//			responseBean.getMsg().setCode("0000");
//			responseBean.getMsg().setDesc("成功");
//			responseBean.setMac(requestBean.getHead().getSerial());
//		}
//
//		return responseBean;
//	}

//	@RequestMapping(value = "/deletePraise", method = { RequestMethod.POST })
//	@ResponseBody
//	public ResponseBean deletePraise(String request) {
//		requestBean = gson.fromJson(request, RequestBean.class);
//		// 进行校验
//		if (requestBean.checkMac()) {
//			LOG.info("校验成功....");
//			// 真正的业务逻辑
//			try {
//				content = requestBean.getContent();
//				Praise praise = gson.fromJson(content.toString(), Praise.class);
//				CommonUtils.decriptObject(praise, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
//				responseBean.setContent(praise);
//			} catch (Exception e) {
//				LOG.error("业务执行异常...." + e.getMessage());
//				responseBean.getMsg().setCode("0001");
//				responseBean.getMsg().setDesc("业务异常");
//				return responseBean;
//			}
//			LOG.info("业务执行成功，设置返回报文状态为成功...");
//			responseBean.getMsg().setCode("0000");
//			responseBean.getMsg().setDesc("成功");
//			responseBean.setMac(requestBean.getHead().getSerial());
//		}
//
//		return responseBean;
//	}
}
