package com.dream.weddingexpo.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.dream.weddingexpo.bean.AdMessage;
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
			String path = ServletActionContext.getServletContext().getRealPath("/")+"text/association/about";
			reader = new BufferedReader(new FileReader(new File(path)));
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
			String path = ServletActionContext.getServletContext().getRealPath("/")+"text/association/join";
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
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
	

	public String listFileName(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = null;
		Gson gson = new Gson();

		String path = ServletActionContext.getServletContext().getRealPath("/")+"text/download/";
		File file = new File(path);
		List<String> fileList = Arrays.asList(file.list());
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		map.put("fileList", fileList);
		try {
			out = response.getWriter();
			out.println(gson.toJson(map));
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
	
	 
	public String listAdMessage(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = null;
		Gson gson = new Gson();
		BufferedReader reader = null;
		List<AdMessage> adMessageList = new ArrayList<AdMessage>();
		
		try {
			String path = ServletActionContext.getServletContext().getRealPath("/")+"text/picconf/URLMapping";
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
			String temp = reader.readLine();
			while(null != temp){
				if(!temp.startsWith("#")){
					StringTokenizer stk = new StringTokenizer(temp," ");
					if(stk.countTokens() == 3){
						AdMessage adMessage = new AdMessage();
						adMessage.setAdMessageTitle(stk.nextToken());
						adMessage.setAdMessagePath(stk.nextToken());
						adMessage.setAdMessageUrl(stk.nextToken());
						adMessageList.add(adMessage);
					}
				}
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
		try {
			out = response.getWriter();
			out.println(gson.toJson(adMessageList));
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
