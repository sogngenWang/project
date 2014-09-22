package com.dreamheaven.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Manu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2158782624452481056L;
	private String classId;
	private String className;
	
	//**************
	private List<Manu> manuList = new ArrayList<Manu>();
	private List<Dish> dishList = new ArrayList<Dish>();

	public List<Manu> getManuList() {
		return manuList;
	}

	public void setManuList(List<Manu> manuList) {
		this.manuList = manuList;
	}

	public List<Dish> getDishList() {
		return dishList;
	}

	public void setDishList(List<Dish> dishList) {
		this.dishList = dishList;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
