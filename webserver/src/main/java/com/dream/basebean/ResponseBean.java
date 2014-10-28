package com.dream.basebean;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dream.utils.CommonUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * POST响应对象
 * 
 * @author 王松根
 * @date 2014年10月28日
 */
@JsonInclude(Include.NON_NULL)
public class ResponseBean {

	public static final Log LOG = LogFactory.getLog(ResponseBean.class);
	// 响应消息对象
	private MsgBean msg = new MsgBean();
	// 响应内容
	private Object content;
	// 响应内容MAC校验值
	private String mac;

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

	/**
	 * 当前只支持content类型分别为 null , ArrayList, Map<String,Object> , Object
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String setMac(String key) {
		// 把content对象转化成Map类型(原来应该是一个对象)
		if (null == content) {
			//针对content为空的情况
			return null;
		}else if (content instanceof ArrayList) {
			//针对传入的是一个List的情况
			this.mac = CommonUtils.caculateList((ArrayList<Object>) content, key);
		}else {
			//普通对象型
			// 把对象转化成map
			Map<String, Object> map = null;
			try {
				map = CommonUtils.objectToMap(null, content);
			} catch (Exception e) {
				LOG.error("objectToMap error  " + e.getMessage());
			}
			this.mac = CommonUtils.calculateMac(map, key);
		} 
		
		return this.mac;
	}
}
