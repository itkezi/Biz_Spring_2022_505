package com.seasoning.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seasoning.app.model.BaseBallScheduleVO;
import com.seasoning.app.persistence.BaseBallDao;
import com.seasoning.app.service.BaseBallService;

@Service
public class BaseBallServiceImpl implements BaseBallService {
	@Autowired
	private BaseBallDao bbDao;

	@Override
	public List<BaseBallScheduleVO> selectJun() {
//		List<BaseBallScheduleVO> bbSchedule = bbDao.selectJun();
//		return bbSchedule;
		return null;
	}

	@Override
	public List<BaseBallScheduleVO> selectJul() {
//		List<BaseBallScheduleVO> bbSchedule = bbDao.selectJul();
//		return bbSchedule;
		return null;
	}

	@Override
	public List<BaseBallScheduleVO> selectAug() {
//		List<BaseBallScheduleVO> bbSchedule = bbDao.selectAug();
//		return bbSchedule;
		return null;
	}

	@Override
	public List<BaseBallScheduleVO> selectSept() {
//		List<BaseBallScheduleVO> bbSchedule = bbDao.selectSept();
//		return bbSchedule;
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
