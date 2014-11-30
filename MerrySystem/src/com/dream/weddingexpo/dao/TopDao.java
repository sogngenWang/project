package com.dream.weddingexpo.dao;

import java.util.List;

import com.dream.weddingexpo.bean.Top;

public interface TopDao {
	
	List<Top> topList(Top top);

	Top detailTop(Top top);

	void addTop(Top top);

	void deleteTop(Top top);

	Top updateTop(Top top);

	List<Top> listTopOrderById(Top top);

}
