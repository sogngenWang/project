package com.dream.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.dream.bean.Kinds;
import com.dream.service.KindsService;

@Controller
public class KindsController {

	@Resource(name = "kinds")
	private Kinds kinds;
	@Resource(name = "kindsService")
	private KindsService kindsService;
}
