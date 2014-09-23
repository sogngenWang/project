package com.dream.service;

import java.util.List;

import com.dream.bean.Kinds;

public interface KindsService {

	Kinds detailKinds(Kinds kinds);

	List<Kinds> listKinds(Kinds kinds);

	Kinds updateKinds(Kinds kinds);

	void addKinds(Kinds kinds);

	void deleteKinds(Kinds kinds);
}
