package com.dream.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.bean.Area;
import com.dream.bean.JsonClazz;
import com.dream.constants.Constant;
import com.dream.service.AreaService;

@Controller
public class AreaController {
	@Resource(name = "jsonClazz")
	private JsonClazz jsonClazz;
	@Resource(name = "areaService")
	private AreaService areaService;

	@RequestMapping(value = "/detailArea")
	@ResponseBody
	public JsonClazz detailArea(Area area) throws Exception {
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_OBJ, areaService.detailArea(area));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	@RequestMapping(value = "/listArea")
	@ResponseBody
	public JsonClazz listArea(Area area, HttpServletRequest request, HttpSession session) throws Exception {
		session.setAttribute("test", "test");
		jsonClazz.getData().clear();
		jsonClazz.getData().put(Constant.JSON_LIST, areaService.listArea(area));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	@RequestMapping(value = "/updateArea")
	@ResponseBody
	public JsonClazz updateArea(Area area) throws Exception {
		jsonClazz.getData().clear();
		jsonClazz.getData()
				.put(Constant.JSON_OBJ, areaService.updateArea(area));
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	@RequestMapping(value = "/addArea")
	@ResponseBody
	public JsonClazz addArea(Area area) throws Exception {
		jsonClazz.getData().clear();
		areaService.addArea(area);
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

	@RequestMapping(value = "/deleteArea")
	@ResponseBody
	public JsonClazz deleteArea(Area area) throws Exception {
		jsonClazz.getData().clear();
		areaService.deleteArea(area.getAreaid());
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}
}
