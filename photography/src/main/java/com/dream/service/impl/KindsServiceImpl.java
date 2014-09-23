package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Kinds;
import com.dream.dao.KindsMapper;
import com.dream.service.KindsService;

@Repository(value = "kindsService")
public class KindsServiceImpl implements KindsService {
	
	@Autowired
	private KindsMapper kindsDao;

	@Override
	public Kinds detailKinds(Kinds kinds) {
		return kindsDao.detailKinds(kinds);
	}

	@Override
	public List<Kinds> listKinds(Kinds kinds) {
		return kindsDao.listKinds(kinds);
	}

	@Override
	public int updateKinds(Kinds kinds) {
		return kindsDao.updateByPrimaryKeySelective(kinds);
	}

	@Override
	public int addKinds(Kinds kinds) {
		return kindsDao.insert(kinds);
	}

	@Override
	public int deleteKinds(int kindsid) {
		return kindsDao.deleteByPrimaryKey(kindsid);
	}


}
