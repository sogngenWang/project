package com.dream.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.bean.JsonClazz;
import com.dream.bean.Commodity;
import com.dream.constants.Constant;
import com.dream.service.CommodityService;

@Controller
public class CommodityController {

	@Resource(name = "jsonClazz")
	private JsonClazz jsonClazz;
	@Resource(name = "commodityService")
	private CommodityService commodityService;
	
	@RequestMapping(value = "/detailCommodity", method = RequestMethod.GET)
	@ResponseBody
	public JsonClazz detailCommodity(Commodity commodity) throws Exception {
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_OBJ,commodityService.detailCommodity(commodity));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}
	
	@RequestMapping(value = "/listCommodity", method = RequestMethod.GET)
	@ResponseBody
	public JsonClazz listCommodity(Commodity commodity)throws Exception{
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_LIST,commodityService.listCommodity(commodity));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}
	
	@RequestMapping(value = "/updateCommodity", method = RequestMethod.GET)
	@ResponseBody
	public JsonClazz updateCommodity(Commodity commodity)throws Exception{
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_OBJ,commodityService.updateCommodity(commodity));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	@RequestMapping(value = "/addCommodity", method = RequestMethod.GET)
	@ResponseBody
	public JsonClazz addCommodity(Commodity commodity)throws Exception{
		jsonClazz.getData().clear();
		commodityService.addCommodity(commodity);
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	
	@RequestMapping(value = "/detailCommodity", method = RequestMethod.GET)
	@ResponseBody
	public JsonClazz deleteCommodity(Commodity commodity)throws Exception{
		jsonClazz.getData().clear();
		commodityService.deleteCommodity(commodity.getCommodityid());
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}


}
