package com.dream.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.baidu.common.GsonUtils;
import com.baidu.security.TDESUtils;
import com.dream.constants.HttpConst;

/**
 * POST响应对象
 * 
 * @author 林翔云
 * @date 2014年10月22日
 */
public class ResponseBean {

	// 响应消息对象
	public MsgBean msg = new MsgBean();
	// 响应内容
	private Map<String, String> content = new HashMap<String, String>();
	// 响应内容MAC校验值
	public String mac = "";

	public Map<String, String> getContent() {
		return content;
	}

	public void setContent(Map<String, String> content) {
		this.content = content;
	}

	/**
	 * 设置MAC
	 * 
	 * @param key
	 *            密钥
	 */
	public void setMac(String key) {
		this.mac = calculateMac(key);
	}

	/**
	 * 计算MAC
	 * 
	 * @return
	 */
	public String calculateMac(String key) {
		// 计算MAC校验信息
		String data = "";
		if (HttpConst.CHECK_FIELDS == null
				|| HttpConst.CHECK_FIELDS.length <= 0) {
			data = GsonUtils.toJson(this.content);
		} else {
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < HttpConst.CHECK_FIELDS.length; i++) {
				String value = (String) content.get(HttpConst.CHECK_FIELDS[i]);
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

	private class MsgBean {

	}

}
