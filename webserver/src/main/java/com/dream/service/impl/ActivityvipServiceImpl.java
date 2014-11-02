package com.dream.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Activity;
import com.dream.bean.Activityvip;
import com.dream.bean.User;
import com.dream.dao.ActivityvipMapper;
import com.dream.dao.UserMapper;
import com.dream.service.ActivityvipService;

@Repository(value = "activityvipService")
public class ActivityvipServiceImpl implements ActivityvipService {

	@Autowired
	private ActivityvipMapper activityvipDao;
	@Autowired
	private UserMapper userDao;
	
	@Override
	public List<User> listUservip(Activity activity) {
		//根据activity id 查询出所有的userid
		List<Activityvip> vips = activityvipDao.listActivityvip(activity);
		//根据vip里的每个userid去查询所有的用户详细信息，过滤掉部分字段
		//TODO 使用批量查询
		List<User> userList = new ArrayList<User>();
		for (Activityvip activityvip : vips) {
			//该方法返回的字段已过滤
			User user = userDao.detailUserForActivityvip(activityvip.getUserid());
			userList.add(user);			
		}
		return userList;
	}


}
