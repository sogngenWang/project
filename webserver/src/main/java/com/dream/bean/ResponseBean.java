package com.dream.bean;

import java.util.ArrayList;
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
	
//	public static final Log LOG = LogFactory.getLog(ResponseBean.class);
	// 响应消息对象
	private MsgBean msg = new MsgBean();
	// 响应内容
	// private Map<String, String> content = new HashMap<String, String>();
	private Object content ;
	// 响应内容MAC校验值
	private String mac;

	// public Map<String, String> getContent() {
	// return content;
	// }
	//
	// public void setContent(Map<String, String> content) {
	// this.content = content;
	// }

	public MsgBean getMsg() {
		return msg;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public void setMsg(MsgBean msg) {
		this.msg = msg;
	}

	public String getMac() {
		return mac;
	}

	@SuppressWarnings("unchecked")
	public String setMac(String key) {
		// 把content对象转化成Map类型(原来应该是一个对象)

		// Map<String, String> map = null;
		// if (null != mac) {
		// return mac;
		// }
		//
		// try {
		// if (null != content) {
		// map = CommonUtils.objectToMap(content);
		// } else {
		// map = new HashMap<String, String>();
		// this.content = map;
		// }
		//
		// this.mac = CommonUtils.calculateMac(map, key);
		// } catch (SecurityException e) {
		// e.printStackTrace();
		// } catch (IllegalArgumentException e) {
		// e.printStackTrace();
		// } catch (NoSuchMethodException e) {
		// e.printStackTrace();
		// } catch (IllegalAccessException e) {
		// e.printStackTrace();
		// } catch (InvocationTargetException e) {
		// e.printStackTrace();
		// }
		if(null == content){
			return null;
		}
		
		if(content.getClass() != ArrayList.class){
			//把对象转化成map
			Map<String,String> map = null ;
			try {
				map = CommonUtils.objectToMap(null, content);
			} catch (Exception e) {
//				LOG.error("objectToMap error  " + e.getMessage());
			}
			
			this.mac = CommonUtils.calculateMac(map , key);
		}else{
			this.mac= CommonUtils.caculateList((ArrayList<Object>) content, key);
		}
		return this.mac;
	}
}
