package com.seasoning.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seasoning.app.model.BaseBallScheduleVO;
import com.seasoning.app.persistence.BaseBallDao;
import com.seasoning.app.service.BaseBallService;

@Service("baseballService")
public class BaseBallServiceImpl implements BaseBallService {
	@Autowired
	private BaseBallDao bbDao;

	@Override
	public List<BaseBallScheduleVO> selectJun() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseBallScheduleVO> selectJul() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseBallScheduleVO> selectAug() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseBallScheduleVO> selectSept() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseBallScheduleVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseBallScheduleVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseBallScheduleVO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseBallScheduleVO> findByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseBallScheduleVO> findByMatch(String match) {
		// TODO Auto-generated method stub
		return null;
	}

}
