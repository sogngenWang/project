package com.dreamheaven.service;

import java.util.List;

import com.dreamheaven.domain.Manu;

public interface ManuService {

	Manu detailManu(Manu manu);

	boolean createManu(Manu manu);

	boolean deleteManu(Manu manu);

	boolean updateManu(Manu manu);

	List<Manu> queryAllManus(Manu manu);

}
