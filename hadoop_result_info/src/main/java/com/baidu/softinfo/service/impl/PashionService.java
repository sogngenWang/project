package com.baidu.softinfo.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baidu.base.model.ResultObj;
import com.baidu.dao.PashionMapper;
import com.baidu.softinfo.service.IPashionService;

@Repository(value="pashionService")
public class PashionService implements IPashionService{

	@Autowired
	private PashionMapper pashionDao;
	
	@Override
	public ResultObj getPashion(String software){
		HashMap<String,String> map = new HashMap<String,String>();
		if(software!=null&&!software.equals("")){
			map.put("software", software.trim());
		}
		ResultObj res =new ResultObj();
		res.setList(pashionDao.selectPashion(map));
		return res;
	}
	
}
