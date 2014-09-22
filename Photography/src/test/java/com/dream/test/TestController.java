package com.dream.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dream.bean.Area;
import com.dream.bean.JsonClazz;
import com.dream.constants.Constant;

@Controller
public class TestController {
	@Resource(name = "jsonClazz")
	private JsonClazz jsonClazz;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public JsonClazz test(Area area) throws Exception {
		jsonClazz.getData().clear();
		List<Area> areaList = new ArrayList<Area>();
		
		area = new Area();
		area.setAreaId("1");
		area.setAreaName("111");
		areaList.add(area);
		
		area = new Area();
		area.setAreaId("2");
		area.setAreaName("222");
		areaList.add(area);
		
		area = new Area();
		area.setAreaId("3");
		area.setAreaName("333");
		areaList.add(area);
		
		area = new Area();
		area.setAreaId("4");
		area.setAreaName("444");
		areaList.add(area);
		
		jsonClazz.getData().put(Constant.JSON_OBJ,"");
		jsonClazz.setState(Constant.SUCCESS);
		jsonClazz.setCode(Constant.SUCCESS_CODE);
		return jsonClazz;
	}

}
