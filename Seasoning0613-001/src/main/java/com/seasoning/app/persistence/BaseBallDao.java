package com.seasoning.app.persistence;

import java.util.List;

import com.seasoning.app.model.BaseBallScheduleVO;

public interface BaseBallDao extends GenericDao<BaseBallScheduleVO, String> {

	// 야구 월별로 불러오기 위해 Select 따로 지정해줌
	public List<BaseBallScheduleVO> selectJun(); // 6월

	public List<BaseBallScheduleVO> selectJul(); // 7월

	public List<BaseBallScheduleVO> selectAug(); // 8월

	public List<BaseBallScheduleVO> selectSept(); // 9월

}
