package com.seasoning.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seasoning.app.model.MapVO;
import com.seasoning.app.persistence.MapDao;
import com.seasoning.app.service.MapService;

@Service
public class MapServiceImpl implements MapService {

	@Autowired
	private MapDao mapDao;

	@Override
	public List<MapVO> selectAll() {
//		List<MapVO> map = mapDao.selectAll();
//		return map;
		return null;
	}

	@Override
	public MapVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MapVO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MapVO> findByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MapVO> findByMatch(String match) {
		// TODO Auto-generated method stub
		return null;
	}

}
