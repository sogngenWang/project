package com.dream.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.bean.JsonClazz;
import com.dream.bean.Kinds;
import com.dream.constants.Constant;
import com.dream.service.KindsService;

@Controller
public class KindsController {
	@Resource(name = "jsonClazz")
	private JsonClazz jsonClazz;
	@Resource(name = "kindsService")
	private KindsService kindsService;
	
	@RequestMapping(value = "/api/detailKinds", method={RequestMethod.GET,RequestMethod.POST} )
	@ResponseBody
	public JsonClazz detailKinds(Kinds kinds) throws Exception {
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_OBJ,kindsService.detailKinds(kinds));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}
	
	@RequestMapping(value = "/api/listKinds" , method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JsonClazz listKinds(Kinds kinds)throws Exception{
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_LIST,kindsService.listKinds(kinds));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}
	
	@RequestMapping(value = "/api/updateKinds" , method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public JsonClazz updateKinds(Kinds kinds)throws Exception{
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_OBJ,kindsService.updateKinds(kinds));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	@RequestMapping(value = "/api/addKinds", method={RequestMethod.GET,RequestMethod.POST} )
	@ResponseBody
	public JsonClazz addKinds(Kinds kinds)throws Exception{
		jsonClazz.getData().clear();
		kindsService.addKinds(kinds);
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	
	@RequestMapping(value = "/api/deleteKinds", method={RequestMethod.GET,RequestMethod.POST} )
	@ResponseBody
	public JsonClazz deleteKinds(Kinds kinds)throws Exception{
		jsonClazz.getData().clear();
		kindsService.deleteKinds(kinds.getKindsid());
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

}
