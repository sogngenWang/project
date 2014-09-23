package com.baidu.base.model;

import java.util.List;

public class ResultObj {
	
	/**
	 * 总数
	 */
	private int total;
	/**
	 * 结果集
	 */
	private List<?> list;
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	
	

}
