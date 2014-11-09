package com.dream.exception;

import java.lang.reflect.Field;

import com.dream.constants.Constant;

public class BussinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private String code;
	
	private String codeDesc;
	
	public BussinessException() {
		super();
	}
	
	public BussinessException(String code){
		this.code = code;
	}

	public String getCode() {
		return code;
	}


	public String getCodeDesc() {
		// TODO 异常还未测试
		String codeStr = "CODE_"+this.code;
		try {
			Field field = Constant.class.getField(codeStr);
			codeDesc =  (String) field.get(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codeDesc;
	}
	
	
}
