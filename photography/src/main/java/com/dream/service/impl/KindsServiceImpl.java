package com.dream.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.dream.bean.Kinds;
import com.dream.dao.KindsDao;
import com.dream.service.KindsService;

@Repository(value = "kindsService")
public class KindsServiceImpl implements KindsService {
	
	@Resource(name = "kindsDao")
	private KindsDao kindsDao;

	@Override
	public Kinds detailKinds(Kinds kinds) {
		return kindsDao.detailKinds(kinds);
	}

	@Override
	public List<Kinds> listKinds(Kinds kinds) {
		return kindsDao.listKinds(kinds);
	}

	@Override
	public Kinds updateKinds(Kinds kinds) {
		return kindsDao.updateKinds(kinds);
	}

	@Override
	public void addKinds(Kinds kinds) {
		kindsDao.addKinds(kinds);
	}

	@Override
	public void deleteKinds(Kinds kinds) {
		kindsDao.deleteKinds(kinds);
	}

}
