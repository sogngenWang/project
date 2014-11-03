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
import com.dream.service.UserService;
import com.google.gson.Gson;

@Controller
public class OthersController {

	public static final Log LOG = LogFactory.getLog(OthersController.class);
	private ResponseBean responseBean = new ResponseBean();
	private Gson gson = new Gson();
	private RequestBean requestBean;
	private Map<String, Object> content;

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping(value = "/search", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean search(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				LOG.info("content is .... " + gson.toJson(content));
				// TODO 搜索算法，根据传过来的参数去搜索——主要搜索 活动主题名
				// 传过来的参数，需要模糊匹配以下几个：活动主题名字，嘉宾名字，查询出的结果按活动开始时间（从晚到早）、关注度（点赞+评论数） 倒序排列

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

		return responseBean;
	}
	
	@RequestMapping(value = "/searchRecommend", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean searchRecommend(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				LOG.info("content is .... " + gson.toJson(content));
				// TODO 搜索页面的推荐信息
				/**
				 * 输入搜索关键字完，默认开始搜索
				 * 在当前搜索页展现搜索结果， 搜索结果即为活动列表
				 * B。活动列表的排序规则：对查询出的结果按活动开始时间（从晚到早）、关注度（点赞+评论数） 倒序排列
				 * C。点击取消，返回到上一页
				 * D。搜索页下默认显示热门搜索信息，热门搜索信息包括活动、嘉宾
				 * E。热门搜索规则：
				 * a.活动：通过活动查阅数+点赞数 TOP4
				 * b.嘉宾：嘉宾有参与过的活动总算排名，TOP4
				 * c.活动子类：好
				 * 初期：因缺少用户偏好数据，无法进行分析，默认只展示默认活动子类
				 * 中后期：根据用户偏好自动匹配出活动子类 或 根据其他用户的类型偏
				 */

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

		return responseBean;
	}
	
	

}
