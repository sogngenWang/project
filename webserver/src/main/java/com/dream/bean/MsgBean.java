package com.dream.bean;

import com.baidu.common.FormatUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 响应消息对象
 * 
 * @author 林翔云
 * @date 2014年10月21日
 */
@JsonInclude(Include.NON_NULL)
public class MsgBean {
	// 时间
	private String time;
	// 类型
	private String type;
	// 代码
	private String code;
	// 描述
	private String desc;

	public String getTime() {
		this.time = FormatUtils.formatDate("yyyy-MM-dd HH:mm:ss,SSS");
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

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
