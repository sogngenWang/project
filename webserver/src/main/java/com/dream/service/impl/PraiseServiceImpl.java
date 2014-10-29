package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Praise;
import com.dream.dao.PraiseMapper;
import com.dream.service.PraiseService;

@Repository(value = "praiseService")
public class PraiseServiceImpl implements PraiseService {

	@Autowired
	private PraiseMapper praiseDao;

	@Override
	public List<Praise> listPraise(Praise praise) {

		return praiseDao.listPraise(praise);
	}

	@Override
	public Praise detailPraise(Praise praise) {

		return praiseDao.detailPraise(praise);
	}

	@Override
	public int updatePraise(Praise praise) {

		return praiseDao.updateByPrimaryKeySelective(praise);
	}

	@Override
	public int deletePraise(int uid) {

		return praiseDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addPraise(Praise praise) {

		return praiseDao.insert(praise);

	}

	@Override
	public int countPraise(Praise praise) {
		
		return praiseDao.countPraise(praise);
	}

}
