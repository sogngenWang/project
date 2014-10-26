package com.dream.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.dream.utils.CommonUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * POST响应对象
 * 
 * @author 林翔云
 * @date 2014年10月22日
 */
@JsonInclude(Include.NON_NULL)
public class ResponseBean {

	// 响应消息对象
	private MsgBean msg = new MsgBean();
	// 响应内容
	private Object content ;
	// 响应内容MAC校验值
	private String mac;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public MsgBean getMsg() {
		return msg;
	}

	public void setMsg(MsgBean msg) {
		this.msg = msg;
	}

	public String getMac() {
		return mac;
	}

	public String setMac(String key) {
		// 把content对象转化成Map类型(原来应该是一个对象)

		Map<String, String> map = null;
		if (null != mac) {
			return mac;
		}

		try {
			if(null != content){
				map = CommonUtils.objectToMap(content);	
			}else{
				map = new HashMap<String,String>();
				this.content = map;
			}
			
			this.mac = CommonUtils.calculateMac(map, key);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return this.mac;
	}
}
