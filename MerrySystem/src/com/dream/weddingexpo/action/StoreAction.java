package com.dream.weddingexpo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import com.dream.weddingexpo.bean.Kinds;
import com.dream.weddingexpo.bean.Store;
import com.dream.weddingexpo.constant.Constants;
import com.dream.weddingexpo.service.KindsService;
import com.dream.weddingexpo.service.StoreService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
public class StoreAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Store store;
	private StoreService storeService;
	private String passwd;
	private String kindsId;
	private KindsService kindsService;
	
	public KindsService getKindsService() {
		return kindsService;
	}

	public void setKindsService(KindsService kindsService) {
		this.kindsService = kindsService;
	}

	public String getKindsId() {
		return kindsId;
	}

	public void setKindsId(String kindsId) {
		this.kindsId = kindsId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public StoreService getStoreService() {
		return storeService;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	/**
	 * 获取所有的商家信息
	 * 
	 * @return
	 */
	public String getStoreList() {
		List<Store> storeList = storeService.listStore(store);
		if (null != storeList) {
			// 返回结果集
			store.setStoreList(storeList);
		}
		return SUCCESS;
	}
	/**
	 * 添加商家
	 */
	
	public String addStore() {
		if(!(Constants.PASSWD).equals(passwd)){
			store.setStoreInfo("密码错误，添加失败");
			return SUCCESS;
		}
		//kindsid 不为null，不为"-1" 不为""的 时候 加入kinds表
		if(null == kindsId  || "-1".equals(kindsId) || kindsId.isEmpty()){
			store.setStoreInfo("请选择分类");
			return SUCCESS;
		}
		
		Store storeTmp = new Store();
		storeTmp.setStoreName(store.getStoreName());
		if(null != storeService.deatilStore(storeTmp)){
			store.setStoreInfo("商店名字不能重复，输入的商店名字数据库中已经存在");
			return SUCCESS;
		}
		
		storeService.addStore(store);
		store = storeService.deatilStore(store);
		
		Kinds kinds = new Kinds();
		kinds.setKindsId(kindsId);
		kinds = kindsService.detailKinds(kinds);
		String kindsSotre = kinds.getKindsStore();
		if(null == kindsSotre){
			kindsSotre = "";
		}
		
		kinds.setKindsStore(kindsSotre + store.getStoreId()+ ";");	
		kindsService.updateKinds(kinds);

		store.setStoreInfo("添加成功");
		
		System.out.println("storeId="+store.getStoreId()+"kindsId="+kinds.getKindsId()+"kindsStore="+kinds.getKindsStore());
		
		return SUCCESS;
	}
	
	
	public String addStoreAjax(){
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		boolean flag = true;
		
		if(!(Constants.PASSWD).equals(passwd)){
			jsonObject.put("state", "FAILED");
			jsonObject.put("info", "添加失败,原因:管理密码错误");
			flag = false;
			
		}else if(null == kindsId  || "-1".equals(kindsId) || kindsId.isEmpty()){
			jsonObject.put("state", "FAILED");
			jsonObject.put("info", "添加失败,原因:请选择分类");
			flag = false;
		} 
		
		Store storeTmp = new Store();
		storeTmp.setStoreName(store.getStoreName());
		if(null != storeService.deatilStore(storeTmp)){
			jsonObject.put("state", "FAILED");
			jsonObject.put("info", "添加失败,原因:商店名字不能重复，输入的商店名字数据库中已经存在");
			flag = false;
		}
		
		if (flag) {
			storeService.addStore(store);
			store = storeService.deatilStore(store);
			Kinds kinds = new Kinds();
			kinds.setKindsId(kindsId);
			kinds = kindsService.detailKinds(kinds);
			String kindsSotre = kinds.getKindsStore();
			if (null == kindsSotre) {
				kindsSotre = "";
			}
			kinds.setKindsStore(kindsSotre + store.getStoreId() + ";");
			kindsService.updateKinds(kinds);

			jsonObject.put("state", "SUCCESS");
			jsonObject.put("info", "添加成功");
			
			System.out.println(jsonObject);
		}
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(jsonObject);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (null != out) {
				out.flush();
				out.close();
			}
		}
		
		return null;
	}
	
	
	
	
}
