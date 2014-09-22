package com.dream.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.dream.bean.Area;
import com.dream.service.AreaService;

@Controller
public class AreaController {
	@Resource(name = "area")
	private Area are;
	@Resource(name = "areaService")
	private AreaService areaService;
	
	
	
}
