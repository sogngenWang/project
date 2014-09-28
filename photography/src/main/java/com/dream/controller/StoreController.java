package com.dream.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.bean.JsonClazz;
import com.dream.bean.Store;
import com.dream.constants.Constant;
import com.dream.service.StoreService;

@Controller
public class StoreController {

	@Resource(name = "jsonClazz")
	private JsonClazz jsonClazz;
	@Resource(name = "storeService")
	private StoreService storeService;
	
	@RequestMapping(value = "/detailStore")
	@ResponseBody
	public JsonClazz detailStore(Store store) throws Exception {
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_OBJ,storeService.detailStore(store));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}
	
	@RequestMapping(value = "/listStore")
	@ResponseBody
	public JsonClazz listStore(Store store)throws Exception{
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_LIST,storeService.listStore(store));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}
	
	@RequestMapping(value = "/updateStore")
	@ResponseBody
	public JsonClazz updateStore(Store store)throws Exception{
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_OBJ,storeService.updateStore(store));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	@RequestMapping(value = "/addStore")
	@ResponseBody
	public JsonClazz addStore(Store store)throws Exception{
		jsonClazz.getData().clear();
		storeService.addStore(store);
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	
	@RequestMapping(value = "/deleteStore")
	@ResponseBody
	public JsonClazz deleteStore(Store store)throws Exception{
		jsonClazz.getData().clear();
		storeService.deleteStore(store.getStoreid());
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}


}
