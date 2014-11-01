package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Checkcode;
import com.dream.dao.CheckcodeMapper;
import com.dream.service.CheckcodeService;

@Repository(value = "checkcodeService")
public class CheckcodeServiceImpl implements CheckcodeService {

	@Autowired
	private CheckcodeMapper checkcodeDao;

	@Override
	public List<Checkcode> listCheckcode(Checkcode checkcode) {

		return checkcodeDao.listCheckcode(checkcode);
	}

	@Override
	public Checkcode detailCheckcode(Checkcode checkcode) {

		return checkcodeDao.detailCheckcode(checkcode);
	}

	@Override
	public int updateCheckcode(Checkcode checkcode) {

		return checkcodeDao.updateByPrimaryKeySelective(checkcode);
	}

	@Override
	public int deleteCheckcode(int uid) {

		return checkcodeDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addCheckcode(Checkcode checkcode) {

		return checkcodeDao.insert(checkcode);

	}

	@Override
	public int countCheckcode(Checkcode checkcode) {

		return checkcodeDao.countCheckcode(checkcode);
	}

}
