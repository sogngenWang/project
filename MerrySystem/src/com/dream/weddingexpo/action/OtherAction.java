package com.dream.weddingexpo.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.dream.weddingexpo.bean.Others;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class OtherAction extends ActionSupport{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String aboutAssociation(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = null;
		Gson gson = new Gson();
		Others others = new Others();
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();

		try {
			String path = ServletActionContext.getServletContext().getRealPath("/")+"text\\association\\about";
			reader = new BufferedReader(new FileReader(new File(path)));
			//TODO 中文乱码
			String temp = reader.readLine();
			while(null != temp){
				sb.append(temp);
				temp = reader.readLine(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != reader){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		others.setAboutAssociation(sb.toString());
		try {
			out = response.getWriter();
			out.println(gson.toJson(others));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}
		
		return null ;
	}
	
	public String joinAssociation(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = null;
		Gson gson = new Gson();
		Others others = new Others();
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();

		try {
			String path = ServletActionContext.getServletContext().getRealPath("/")+"text\\association\\join";
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
			//TODO 中文乱码
			String temp = reader.readLine();
			while(null != temp){
				sb.append(temp);
				temp = reader.readLine(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != reader){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		others.setJoinAssociation(sb.toString());
		try {
			out = response.getWriter();
			out.println(gson.toJson(others));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}
		
		return null ;
	}
	
}
