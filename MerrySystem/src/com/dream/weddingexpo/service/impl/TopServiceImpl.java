package com.dream.weddingexpo.service.impl;

import java.util.List;

import com.dream.weddingexpo.bean.Top;
import com.dream.weddingexpo.dao.TopDao;
import com.dream.weddingexpo.service.TopService;

public class TopServiceImpl implements TopService {

	private TopDao topDao;

	public TopDao getTopDao() {
		return topDao;
	}

	public void setTopDao(TopDao topDao) {
		this.topDao = topDao;
	}

	@Override
	public void addTop(Top top) {
		topDao.addTop(top);
	}

	@Override
	public List<Top> listTop(Top top) {
		List<Top> topList = topDao.topList(top);

		return topList;
	}

	@Override
	public Top detailTop(Top top) {
		top = topDao.detailTop(top);
		return top;
	}

	@Override
	public List<Top> listTopNoContent(Top top) {
		List<Top> topList = topDao.topList(top);
		return topList;
	}

	@Override
	public void deleteTop(Top top) {
		topDao.deleteTop(top);
	}

	@Override
	public Top updateTop(Top top) {

		return topDao.updateTop(top);
	}

}
