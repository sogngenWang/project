package com.dream.bean;

import java.util.HashMap;
import java.util.Map;

import com.dream.utils.CommonUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * POST请求对象
 * 
 * @author 林翔云
 * @date 2014年10月21日
 */
@JsonInclude(Include.NON_NULL)
public class RequestBean {

	// 请求头部对象
	private HeadBean head = new HeadBean();
	// 请求内容
	private Map<String, String> content = new HashMap<String, String>();
	// 请求内容MAC校验值
	private String mac;

	public void setHead(HeadBean head) {
		this.head = head;
	}

	public void setContent(Map<String, String> content) {
		this.content = content;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public HeadBean getHead() {
		return head;
	}

	public Map<String, String> getContent() {
		return content;
	}

	public String getMac() {
		this.mac = CommonUtils.calculateMac(content, head.getSerial());
		return this.mac;
	}

	/**
	 * 校验MAC
	 * 
	 * @param key
	 * @return
	 */
	public boolean checkMac() {
		return getMac().equals(mac);
	}

}
