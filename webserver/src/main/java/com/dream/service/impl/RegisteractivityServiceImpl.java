package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Registeractivity;
import com.dream.dao.RegisteractivityMapper;
import com.dream.service.RegisteractivityService;

@Repository(value = "registeractivityService")
public class RegisteractivityServiceImpl implements RegisteractivityService {

	@Autowired
	private RegisteractivityMapper registeractivityDao;

	@Override
	public List<Registeractivity> listRegisteractivity(Registeractivity registeractivity) {

		return registeractivityDao.listRegisteractivity(registeractivity);
	}

	@Override
	public Registeractivity detailRegisteractivity(Registeractivity registeractivity) {

		return registeractivityDao.detailRegisteractivity(registeractivity);
	}

	@Override
	public int updateRegisteractivity(Registeractivity registeractivity) {

		return registeractivityDao.updateByPrimaryKeySelective(registeractivity);
	}

	@Override
	public int deleteRegisteractivity(int uid) {

		return registeractivityDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addRegisteractivity(Registeractivity registeractivity) {

		return registeractivityDao.insert(registeractivity);

	}

	@Override
	public int countRegisteractivity(Registeractivity registeractivity) {

		return registeractivityDao.countRegisteractivity(registeractivity);
	}

}
