package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Userinfo;
import com.dream.dao.UserinfoMapper;
import com.dream.service.UserinfoService;

@Repository(value = "userinfoService")
public class UserinfoServiceImpl implements UserinfoService {

	@Autowired
	private UserinfoMapper userinfoDao;

	@Override
	public List<Userinfo> listUserinfo(Userinfo userinfo) {

		return userinfoDao.listUserinfo(userinfo);
	}

	@Override
	public Userinfo detailUserinfo(Userinfo userinfo) {

		return userinfoDao.detailUserinfo(userinfo);
	}

	@Override
	public int updateUserinfo(Userinfo userinfo) {

		return userinfoDao.updateByPrimaryKeySelective(userinfo);
	}

	@Override
	public int deleteUserinfo(int uid) {

		return userinfoDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addUserinfo(Userinfo userinfo) {

		return userinfoDao.insert(userinfo);

	}

	@Override
	public int countUserinfo(Userinfo userinfo) {
		
		return userinfoDao.countUserinfo(userinfo);
	}

}
