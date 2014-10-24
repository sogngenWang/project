package com.dream.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.baidu.common.GsonUtils;
import com.baidu.security.TDESUtils;
import com.dream.constants.HttpConst;

/**
 * POST请求对象
 * 
 * @author 林翔云
 * @date 2014年10月21日
 */
public class RequestBean {

	// 请求头部对象
	private HeadBean head = null;
	// 请求内容
	private Map<String, String> content = null;
	// 请求内容MAC校验值
	private String mac = "";

	/**
	 * 构造函数
	 */
	public RequestBean() {
		head = new HeadBean();
		content = new HashMap<String, String>();
	}

	/**
	 * 获得请求头部对象
	 * 
	 * @return
	 */
	public HeadBean getHead() {
		return head;
	}

	/**
	 * 获得请求内容
	 * 
	 * @return
	 */
	public Map<String, String> getContent() {
		return content;
	}

	/**
	 * 获得校验信息
	 * 
	 * @return
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * 计算MAC
	 * 
	 * @return
	 */
	private String calculateMac(String key) {
		// 计算MAC校验信息
		String data = "";
		if (HttpConst.CHECK_FIELDS == null
				|| HttpConst.CHECK_FIELDS.length == 0) {
			data = GsonUtils.toJson(content);
		} else {
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < HttpConst.CHECK_FIELDS.length; i++) {
				String value = content.get(HttpConst.CHECK_FIELDS[i]);
				if (StringUtils.isNotBlank(value)) {
					buffer.append(value);
				}
			}
			data = buffer.toString();
			if (StringUtils.isBlank(data)) {
				data = GsonUtils.toJson(this.content);
			}
		}
		return TDESUtils.MAC_ECB(data, key);
	}

	/**
	 * 校验MAC
	 * 
	 * @param key
	 * @return
	 */
	public boolean checkMac(String key) {
		return calculateMac(key).equals(mac);
	}

}
