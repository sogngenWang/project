package com.dream.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.dream.bean.Store;
import com.dream.service.StoreService;

@Controller
public class StoreController {

	@Resource(name = "store")
	private Store store;
	@Resource(name = "storeService")
	private StoreService storeService;
}
