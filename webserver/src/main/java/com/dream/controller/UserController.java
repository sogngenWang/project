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
import com.dream.bean.User;
import com.dream.constants.Constant;
import com.dream.service.CheckcodeService;
import com.dream.service.UserService;
import com.dream.utils.CommonUtils;
import com.google.gson.Gson;

@Controller
public class UserController {

	public static final Log LOG = LogFactory.getLog(UserController.class);
	private ResponseBean responseBean = new ResponseBean();
	private Gson gson = new Gson();
	private RequestBean requestBean;
	private Map<String, Object> content;

	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "checkcodeService")
	private CheckcodeService checkcodeService;

//	@RequestMapping(value = "/addUser", method = { RequestMethod.POST })
//	@ResponseBody
//	public ResponseBean addUser(String request) {
//		requestBean = gson.fromJson(request, RequestBean.class);
//		// 进行校验
//		if (requestBean.checkMac()) {
//			LOG.info("校验成功....");
//			// 真正的业务逻辑
//			try {
//				content = requestBean.getContent();
//				User user = gson.fromJson(content.toString(), User.class);
//				CommonUtils.decriptObject(user, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
//				userService.addUser(user);
//				responseBean.setContent(user);
//			} catch (Exception e) {
//				LOG.error("业务执行异常...." + e.getMessage()+e.getCause().getMessage());
//				responseBean.getMsg().setCode("0001");
//				responseBean.getMsg().setDesc("业务异常");
//				return responseBean;
//			}
//			LOG.info("业务执行成功，设置返回报文状态为成功...");
//			responseBean.getMsg().setCode("0000");
//			responseBean.getMsg().setDesc(Constant.CODE_0000);
//			responseBean.setMac(requestBean.getHead().getSerial());
//		}
//		LOG.info("返回报文是:"+gson.toJson(responseBean));
//		return responseBean;
//	}

//	@RequestMapping(value = "/detailUser", method = { RequestMethod.POST })
//	@ResponseBody
//	public ResponseBean detailUser(String request) {
//		requestBean = gson.fromJson(request, RequestBean.class);
//		// 进行校验
//		if (requestBean.checkMac()) {
//			LOG.info("校验成功....");
//			// 真正的业务逻辑
//			try {
//				content = requestBean.getContent();
//				User user = gson.fromJson(content.toString(), User.class);
//				CommonUtils.decriptObject(user, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
//				user = userService.detailUser(user);
//				responseBean.setContent(user);
//			} catch (Exception e) {
//				LOG.error("业务执行异常...." + e.getMessage());
//				responseBean.getMsg().setCode("0001");
//				responseBean.getMsg().setDesc("业务异常");
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

//	@RequestMapping(value = "/listUser", method = { RequestMethod.POST })
//	@ResponseBody
//	public ResponseBean listUser(String request) {
//		requestBean = gson.fromJson(request, RequestBean.class);
//		// 进行校验
//		if (requestBean.checkMac()) {
//			LOG.info("校验成功....");
//			// 真正的业务逻辑
//			try {
//				content = requestBean.getContent();
//				User user = gson.fromJson(content.toString(), User.class);
//				CommonUtils.decriptObject(user, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
//				List<User> userList = userService.listUser(user);
//				responseBean.setContent(userList);
//			} catch (Exception e) {
//				LOG.error("业务执行异常...." + e.getMessage());
//				responseBean.getMsg().setCode("0001");
//				responseBean.getMsg().setDesc("业务异常");
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

//	@RequestMapping(value = "/updateUser", method = { RequestMethod.POST })
//	@ResponseBody
//	public ResponseBean updateUser(String request) {
//		requestBean = gson.fromJson(request, RequestBean.class);
//		// 进行校验
//		if (requestBean.checkMac()) {
//			LOG.info("校验成功....");
//			// 真正的业务逻辑
//			try {
//				content = requestBean.getContent();
//				User user = gson.fromJson(content.toString(), User.class);
//				CommonUtils.decriptObject(user, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
//				userService.updateUser(user);
//				responseBean.setContent(user);
//			} catch (Exception e) {
//				LOG.error("业务执行异常...." + e.getMessage());
//				responseBean.getMsg().setCode("0001");
//				responseBean.getMsg().setDesc("业务异常");
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

//	@RequestMapping(value = "/deleteUser", method = { RequestMethod.POST })
//	@ResponseBody
//	public ResponseBean deleteUser(String request) {
//		requestBean = gson.fromJson(request, RequestBean.class);
//		// 进行校验
//		if (requestBean.checkMac()) {
//			LOG.info("校验成功....");
//			// 真正的业务逻辑
//			try {
//				content = requestBean.getContent();
//				User user = gson.fromJson(content.toString(), User.class);
//				CommonUtils.decriptObject(user, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
//				responseBean.setContent(user);
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
	/**
	 * 用户登录
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/loginUser", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean loginUser(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				User user = gson.fromJson(content.toString(), User.class);
				CommonUtils.decriptObject(user, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				LOG.info("用户名，密码 |username="+user.getUsername()+",password="+user.getPassword());
//				user = userService.detailUser(user);
				user = userService.loginUser(user);
				if(null == user){
					//用户名或者密码错误
					LOG.error("用户名或者密码错误");
					responseBean.getMsg().setCode("0002");
					responseBean.getMsg().setDesc(Constant.CODE_0002);
					return responseBean;
				}
				responseBean.setContent(user);
			} catch (Exception e) {
				LOG.error("业务执行异常...." + e.getMessage());
				responseBean.getMsg().setCode("0001");
				responseBean.getMsg().setDesc(Constant.CODE_0000);
				return responseBean;
			}
			LOG.info("业务执行成功，设置返回报文状态为成功...");
			responseBean.getMsg().setCode("0000");
			responseBean.getMsg().setDesc(Constant.CODE_0000);
			responseBean.setMac(requestBean.getHead().getSerial());
		}

		return responseBean;
	}
	
	/**
	 * 用户注册
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/registerUser", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean registerUser(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				User user = gson.fromJson(content.toString(), User.class);
				CommonUtils.decriptObject(user, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				//判断手机号是否已经存在，即已经注册过的手机号，对于这种手机号，只能通过找回密码功能
				User userTmp = new User();
				userTmp.setTelephone(user.getTelephone());
				//查找该手机号用户是否存在，如果存在则返回失败
				if(null != userService.detailUser(userTmp)){
					LOG.error("用户名或者密码错误");
					responseBean.getMsg().setCode("0003");
					responseBean.getMsg().setDesc(Constant.CODE_0003);
					return responseBean;
				}
				//校验码验证查询
				Checkcode checkcode = new Checkcode();
				checkcode.setTelephone(user.getTelephone());
				checkcode.setCheckcode(user.getCheckcode());
				LOG.info("checkcode="+user.getCheckcode()+"|telephone = "+user.getTelephone());
				checkcode = checkcodeService.detailCheckcode(checkcode);
				if(null == checkcode){
					responseBean.getMsg().setCode("0004");
					responseBean.getMsg().setDesc(Constant.CODE_0004);
					return responseBean;
				}else{
					//判断校验码是否过期
					if(CommonUtils.isCheckCodeExpire(checkcode.getCreatetime())){
						//校验码过期
						responseBean.getMsg().setCode("0005");
						responseBean.getMsg().setDesc(Constant.CODE_0005);
						return responseBean;
					}
					//真正的注册该用户
					userService.addNormalUser(user);
					//注册完用户需要把该用户资料填充到名片夹中  TODO
					
				}
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
	/**
	 * 找回用户密码 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/findbackUser", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean findback(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				User user = gson.fromJson(content.toString(), User.class);
				CommonUtils.decriptObject(user, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				//获取手机号，然后发送验证码到手机上,再次确认
//				String telephone = user.getTelephone();
//				String checkCode = CommonUtils.createCheckCode(Constant.CHECKCODE_LENGTH);
//				// 发送校验码到手机上
//				CommonUtils.sendCheckCode(telephone, checkCode);
//				LOG.info("telephone = "+ telephone +"checkCode = " + checkCode);
//				// 把该娇艳存入到数据库中
//				Checkcode checkcode = new Checkcode();
//				checkcode.setTelephone(telephone);
//				checkcode.setCheckcode(checkCode);
//				checkcode.setCreatetime(CommonUtils.getSYSDate());
				checkcodeService.addCheckcodeAndSendMobile(user.getTelephone());
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
	
	/**
	 * 重置用户密码
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/resetPasswdUser", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseBean resetPasswd(String request) {
		requestBean = gson.fromJson(request, RequestBean.class);
		// 进行校验
		if (requestBean.checkMac()) {
			LOG.info("校验成功....");
			// 真正的业务逻辑
			try {
				content = requestBean.getContent();
				User user = gson.fromJson(content.toString(), User.class);
				CommonUtils.decriptObject(user, requestBean.getHead().getImei(), requestBean.getHead().getImsi());
				//校验码验证查询
				Checkcode checkcode = new Checkcode();
				checkcode.setTelephone(user.getTelephone());
				checkcode.setCheckcode(user.getCheckcode());
				LOG.info("checkcode="+user.getCheckcode()+"|telephone = "+user.getTelephone());
				checkcode = checkcodeService.detailCheckcode(checkcode);
				if(null == checkcode){
					responseBean.getMsg().setCode("0004");
					responseBean.getMsg().setDesc(Constant.CODE_0004);
					return responseBean;
				}else{
					//判断校验码是否过期
					if(CommonUtils.isCheckCodeExpire(checkcode.getCreatetime())){
						//校验码过期
						responseBean.getMsg().setCode("0005");
						responseBean.getMsg().setDesc(Constant.CODE_0005);
						return responseBean;
					}
					//校验码验证正确,修改密码
					userService.updateByTelephone(user);
				}
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
