package com.dreamheaven.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.dreamheaven.dao.ManuDao;
import com.dreamheaven.domain.Manu;
import com.dreamheaven.service.ManuService;

public class ManuServiceImpl implements ManuService {

	private static Logger logger = Logger.getLogger(ManuServiceImpl.class);

	public ManuDao manuDao;

	public ManuDao getManuDao() {
		return manuDao;
	}

	public void setManuDao(ManuDao manuDao) {
		this.manuDao = manuDao;
	}

	public boolean createManu(Manu manu) {
		manuDao.createManu(manu);
		return false;
	}

	public boolean deleteManu(Manu manu) {
		manuDao.deleteManu(manu);
		return false;
	}

	public Manu detailManu(Manu manu) {
		return manuDao.detailManu(manu);
	}

	public List<Manu> queryAllManus(Manu manu) {

		return manuDao.queryManu(manu);
	}

	public boolean updateManu(Manu manu) {
		manuDao.updateManu(manu);
		return false;
	}

}
