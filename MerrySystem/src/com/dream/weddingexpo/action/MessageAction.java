package com.dream.weddingexpo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import com.dream.weddingexpo.bean.Message;
import com.dream.weddingexpo.bean.Top;
import com.dream.weddingexpo.bean.User;
import com.dream.weddingexpo.constant.Constants;
import com.dream.weddingexpo.service.MessageService;
import com.dream.weddingexpo.service.TopService;
import com.dream.weddingexpo.service.UserService;
import com.dream.weddingexpo.utils.CommonUtils;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
public class MessageAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Message message;
	private MessageService messageService;
	private UserService userService;
	private TopService topService; 
	

	public TopService getTopService() {
		return topService;
	}

	public void setTopService(TopService topService) {
		this.topService = topService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	/**
	 * 根据传入的meesageId获取messge详情
	 * 
	 * @param message
	 * @return
	 */
	public String detailMessage() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");

		message = messageService.detailMessage(message);
		//根据id查询该新闻是否是属于置顶列表中，如果属于，则置顶
		if(null != message){
			Top top = new Top();
			top.setMessageId(message.getMessageId());
			top = topService.detailTop(top);
			if(null != top){
				//说明该新闻是置顶新闻,同时返回置顶id、
				message.setIsTop(top.getTopId());
			}
		}
		
		PrintWriter out = null;
		Gson gson = new Gson();

		try {
			out = response.getWriter();
			out.println(gson.toJson(message));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}

		return null;
	}

	/**
	 * 显示新闻信息
	 */
	public String listMessage() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");

		List<Message> messageList = messageService.listMessageInclueTop(message);
		if (null != messageList) {
			// 返回结果集
			message.setMessageList(messageList);
		}
		PrintWriter out = null;
		Gson gson = new Gson();

		try {
			out = response.getWriter();
			out.println(gson.toJson(message));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}

		return null;
	}

	/**
	 * 添加新闻
	 * 
	 */
	public String addMessage() {
		if(StringUtils.isBlank(message.getUsername()) || StringUtils.isBlank(message.getPassword())){
			message.setMessageInfo("添加失败，用户名，密码不能为空");
			return  ERROR;
		}
		// 判断是否有权限
		User user = new User();
		user.setUserName(message.getUsername());
		user.setPasswd(message.getPassword());
		user = userService.detailUser(user);
		if(null == user){
			message.setMessageInfo("添加失败，用户名或者密码错误");
			return  ERROR;
		}else{
			if(user.getIsActive() == Constants.USER_STATE_NOTACTIVE){
				message.setMessageInfo("添加失败，用户名未被激活");
				return  ERROR;
			}
		}
		
		try {
			message.setCreateTime(CommonUtils.getTime());
			messageService.addMessage(message);
			message.setMessageInfo("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	/**
	public String listMessageNoContent() {
		List<Message> messageList = messageService.listMessageNoContent(message);
		if (null != messageList) {
			// 返回结果集
			message.setMessageList(messageList);
		}
		return SUCCESS;
	}
*/
	public String updateMessage() {
		if(StringUtils.isBlank(message.getUsername()) || StringUtils.isBlank(message.getPassword())){
			message.setMessageInfo("添加失败，用户名，密码不能为空");
			return  ERROR;
		}
		// 判断是否有权限
		User user = new User();
		user.setUserName(message.getUsername());
		user.setPasswd(message.getPassword());
		user = userService.detailUser(user);
		if(null == user){
			message.setMessageInfo("添加失败，用户名或者密码错误");
			return  ERROR;
		}else{
			if(user.getIsActive() == Constants.USER_STATE_NOTACTIVE){
				message.setMessageInfo("添加失败，用户名未被激活");
				return  ERROR;
			}
		}
		//标题不能为空
		if(StringUtils.isBlank(message.getMessageId()) || StringUtils.isBlank(message.getMessageTitle())){
			message.setMessageInfo("添加失败，新闻id或者新闻标题均不能为空");
			return  ERROR;
		}
		
		
		//修改内容
		message.setLastUpdateTime(CommonUtils.getTime());
		
		Message messageTmp = new Message();
		messageTmp.setMessageId(message.getMessageId());
		messageTmp = messageService.detailMessageOnly(messageTmp);
		message.setCreateTime(messageTmp.getCreateTime());
		messageService.updateMessage(message);
		
		//该值不为空，说明需要修改该值
//		if(StringUtils.isNotBlank(message.getIsTop())){
			
			//修改置顶信息 -- 先根据新闻id查询置顶表，假如不存在则说明
			Top top = new Top();
			List<Top>  topList = new ArrayList<Top>();
			top.setMessageId(message.getMessageId());
			top = topService.detailTop(top);
			
			if(null != top){
				//删除原有的置顶信息
				topService.deleteTop(top);
			}
			
			topList = topService.listTopOrderById(new Top());
				// 不存在的，直接根据选择的置顶id置顶
				int num = Integer.valueOf(message.getIsTop());
				int j = 1 ;
				
				// 如果输入的置顶值很大，则默认设置成最后一个
				if( num < 1){
					//亲空所有
					for (Top topTmp : topList) {
						topService.deleteTop(topTmp);
					}
					Top topT = new Top();
					topT.setMessageId(message.getMessageId());
					topT.setTopId(String.valueOf(1));
					topService.addTop(topT);
					for (int i = 2; i <= topList.size()+1 ; i++) {
						topT = topList.get(i-2);
						topT.setTopId(String.valueOf(i));
						topService.addTop(topT);
					}
					
				}else if( num > topList.size() ){
					Top topT = new Top();
					topT.setMessageId(String.valueOf(topList.size()));
					topT.setTopId(String.valueOf(j++));
					topService.addTop(topT);
				}else{
					//亲空所有
					for (Top topTmp : topList) {
						topService.deleteTop(topTmp);
					}
					
					for (int i = 1; i <= topList.size() ; i++) {
						if(i == num){
							Top topT = new Top();
							topT.setMessageId(message.getMessageId());
							topT.setTopId(String.valueOf(j++));
							topService.addTop(topT);
						} 
						Top topT = topList.get(i-1);
						if(null != topT){
							topT.setTopId(String.valueOf(j++));
							topService.addTop(topT);
						}
					}
				}
				
		
//		}else{
//			//为空。则删除置顶信息
//			Top topTT = new Top();
//			topTT.setMessageId(message.getMessageId());
//			topService.deleteTop(topTT);
//		}
		return SUCCESS;
	}
	
	
	public String deleteMessage(){
		
//		if(StringUtils.isBlank(message.getUsername()) || StringUtils.isBlank(message.getPassword())){
//			message.setMessageInfo("添加失败，用户名，密码不能为空");
//			return  SUCCESS;
//		}
//		// 判断是否有权限
//		User user = new User();
//		user.setUserName(message.getUsername());
//		user.setPasswd(message.getPassword());
//		user = userService.detailUser(user);
//		if(null == user){
//			message.setMessageInfo("添加失败，用户名或者密码错误");
//			return  SUCCESS;
//		}else{
//			if(user.getIsActive() == Constants.USER_STATE_NOTACTIVE){
//				message.setMessageInfo("添加失败，用户名未被激活");
//				return  SUCCESS;
//			}
//		}
		Top top = new Top();
		top.setMessageId(message.getMessageId());
		if(null != (top = topService.detailTop(top))){
			topService.deleteTop(top);
		}
		
		message = messageService.detailMessageOnly(message);
		messageService.deleteMessage(message);
		
		return SUCCESS;
	}

}
