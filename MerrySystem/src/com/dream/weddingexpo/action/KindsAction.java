package com.dream.weddingexpo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.dream.weddingexpo.bean.Kinds;
import com.dream.weddingexpo.bean.Store;
import com.dream.weddingexpo.service.KindsService;
import com.opensymphony.xwork2.ActionSupport;

public class KindsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Kinds kinds;
	private String kindsStore;
	private KindsService kindsService;

	public KindsService getKindsService() {
		return kindsService;
	}

	public void setKindsService(KindsService kindsService) {
		this.kindsService = kindsService;
	}

	public Kinds getKinds() {
		return kinds;
	}

	public void setKinds(Kinds kinds) {
		this.kinds = kinds;
	}

	public String getKindsStore() {
		return kindsStore;
	}

	public void setKindsStore(String kindsStore) {
		this.kindsStore = kindsStore;
	}

	public String listStoreByKindsStore() {
		kinds.setKindsStore(kindsStore);
		List<Store> storeList = kindsService.listStoreByKindsStore(kinds.getKindsStore());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		JSONArray obj = new JSONArray();
		obj.add(storeList.toArray());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("storeList", obj.toString().substring(1,
				obj.toString().length() - 1));

		System.out.println(jsonObject);
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(jsonObject);
		} catch (IOException e) {
			// TODO
			System.out.println(e.getMessage());
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}
		return null;
	}	
	
	public String listKinds() {
		List<Kinds> kindsList = kindsService.listKinds(kinds);
		kinds.setKindsList(kindsList);
		return SUCCESS;
	}
}
