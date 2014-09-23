package com.dream.service;

import java.util.List;

import com.dream.bean.Kinds;

public interface KindsService {

	Kinds detailKinds(Kinds kinds);

	List<Kinds> listKinds(Kinds kinds);

	int updateKinds(Kinds kinds);

	int addKinds(Kinds kinds);

	int deleteKinds(int kindsid);
}
