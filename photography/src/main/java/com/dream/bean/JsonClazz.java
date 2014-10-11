package com.dream.bean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository(value="jsonClazz")
public class JsonClazz extends BaseBean {
	/**
	 * 该类用于跟前台的json交互
	 */
	
	private String state;
	private String code;
	private Map<String, Object> data = new HashMap<String, Object>();
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
