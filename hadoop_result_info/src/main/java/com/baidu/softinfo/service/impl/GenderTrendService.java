package com.baidu.softinfo.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baidu.base.model.ResultObj;
import com.baidu.dao.GenderTrendMapper;
import com.baidu.softinfo.service.IGenderTrendService;

@Repository(value="genderTrendService")
public class GenderTrendService implements IGenderTrendService{

	@Autowired
	private GenderTrendMapper genderTrendDao;
	
	
	
	
	@Override
	public ResultObj getGenderTrend(String software){
		HashMap<String,String> map = new HashMap<String,String>();
		if(software!=null&&!software.equals("")){
			map.put("software", software.trim());
		}
		
		ResultObj res =new ResultObj();
		res.setList(genderTrendDao.selectGenderTrend(map));
		return res;
	}
	
	
}
