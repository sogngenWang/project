package com.dream.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.dream.bean.Commodity;
import com.dream.service.CommodityService;

@Controller
public class CommodityController {

	@Resource(name = "commodity")
	private Commodity commodity;
	@Resource(name = "commodityService")
	private CommodityService commodityService;
}
