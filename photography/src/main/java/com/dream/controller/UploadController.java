package com.dream.controller;

import javax.annotation.Resource;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dream.bean.JsonClazz;

@Controller
public class UploadController {

	@Resource(name = "jsonClazz")
	private JsonClazz jsonClazz;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public JsonClazz upload(@RequestParam("name") String name, @RequestParam("file") Part file) throws Exception {
		System.out.println("success");
		return null;
	}

}
