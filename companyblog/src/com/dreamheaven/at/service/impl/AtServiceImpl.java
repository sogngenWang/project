package com.dreamheaven.at.service.impl;

import java.util.List;

import com.dreamheaven.at.dao.AtDao;
import com.dreamheaven.at.domain.At;
import com.dreamheaven.at.service.AtService;

public class AtServiceImpl implements AtService{
	
	private AtDao atDao ;

	public AtDao getAtDao() {
		return atDao;
	}

	public void setAtDao(AtDao atDao) {
		this.atDao = atDao;
	}

	@Override
	public List<At> queryAt(At at) {

		return atDao.queryAt(at);
	}

	@Override
	public void createAt(At at) {
		
		atDao.createAt(at);

	}

	@Override
	public void deleteAt(At at) {
		atDao.deleteAt(at);
	}

}
