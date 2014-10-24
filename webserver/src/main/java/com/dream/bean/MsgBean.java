package com.dream.bean;

import com.baidu.common.FormatUtils;

/**
 * 响应消息对象
 * 
 * @author 林翔云
 * @date 2014年10月21日
 */
public class MsgBean {
	// 时间
	public String time = FormatUtils.formatDate("yyyy-MM-dd HH:mm:ss,SSS");
	// 类型
	public String type = "";
	// 代码
	public String code = "";
	// 描述
	public String desc = "";

	public void setType(String type) {
		this.type = type;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
