package com.dream.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dream.bean.Ad;
import com.dream.dao.AdMapper;
import com.dream.service.AdService;

@Repository(value = "adService")
public class AdServiceImpl implements AdService{
	
	@Autowired
	private AdMapper adDao;

	@Override
	public List<Ad> listRandomAd(Ad ad) {
//		int count = adDao.countAd(new Ad());
		List<Ad> adList = adDao.listAd(ad);
		
		return adList;
	}
	
}
