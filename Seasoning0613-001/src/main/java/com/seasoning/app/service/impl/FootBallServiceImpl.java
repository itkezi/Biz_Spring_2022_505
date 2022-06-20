package com.seasoning.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seasoning.app.model.FootBallScheduleVO;
import com.seasoning.app.persistence.FootBallDao;
import com.seasoning.app.service.FootBallService;

@Service
public class FootBallServiceImpl implements FootBallService {

//	private final FootBallDao fbDao;
//
//	public FootBallServiceImpl(FootBallDao fbDao) {
//		this.fbDao = fbDao;
//	}
	
	@Autowired
	private FootBallDao fbDao;

	@Override
	public List<FootBallScheduleVO> findByTime(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FootBallScheduleVO> selectAll() {
//		List<FootBallScheduleVO> fbSchedule = fbDao.selectAll();
//		return fbSchedule;
		return null;
	}

	@Override
	public FootBallScheduleVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FootBallScheduleVO> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FootBallScheduleVO> findByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FootBallScheduleVO> findByMatch(String match) {
		// TODO Auto-generated method stub
		return null;
	}

}
