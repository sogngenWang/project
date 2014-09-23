package com.baidu.softinfo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.base.model.ResultObj;
import com.baidu.softinfo.service.IGenderTrendService;
import com.baidu.softinfo.service.IPashionService;

@Controller
public class SoftInfoController {
	
	@Resource(name="genderTrendService")
	private IGenderTrendService genderTrendService;
	
	@Resource(name="pashionService")
	private IPashionService pashionService;
	
	
	
	@RequestMapping(value="/softInfo/genderTrend/{software:.*}",method=RequestMethod.GET)
	@ResponseBody
	public ResultObj getGenderTrend(@PathVariable String software){
		return genderTrendService.getGenderTrend(software);
	}
	
//	getPashion
	
	@RequestMapping(value="/softInfo/pashion/{software:.*}",method=RequestMethod.GET)
	@ResponseBody
	public ResultObj getPashion(@PathVariable String software){
		System.out.println(software);
		return pashionService.getPashion(software);
	}
	
	
	@RequestMapping(value="/softInfo")
	public ModelAndView getSoftInfo(){
		return new ModelAndView("softinfo");
	}

}
