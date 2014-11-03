package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Onlinequestion;
import com.dream.dao.OnlinequestionMapper;
import com.dream.service.OnlinequestionService;

@Repository(value = "onlinequestionService")
public class OnlinequestionServiceImpl implements OnlinequestionService {

	@Autowired
	private OnlinequestionMapper onlinequestionDao;

	@Override
	public List<Onlinequestion> listOnlinequestion(Onlinequestion onlinequestion) {

		return onlinequestionDao.listOnlinequestion(onlinequestion);
	}

	@Override
	public Onlinequestion detailOnlinequestion(Onlinequestion onlinequestion) {

		return onlinequestionDao.detailOnlinequestion(onlinequestion);
	}

	@Override
	public int updateOnlinequestion(Onlinequestion onlinequestion) {

		return onlinequestionDao.updateByPrimaryKeySelective(onlinequestion);
	}

	@Override
	public int deleteOnlinequestion(int uid) {

		return onlinequestionDao.deleteByPrimaryKey(uid);

	}

	@Override
	public int addOnlinequestion(Onlinequestion onlinequestion) {

		return onlinequestionDao.insert(onlinequestion);

	}

	@Override
	public int countOnlinequestion(Onlinequestion onlinequestion) {

		return onlinequestionDao.countOnlinequestion(onlinequestion);
	}

}
