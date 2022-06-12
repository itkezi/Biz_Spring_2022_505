package com.seasoning.app.persistence;

import java.util.List;

public interface GenericDao<VO, PK> {
	
	public List<VO> selectAll();
	
	public VO findById(PK id); 	// 일단 만들어 놓은 거
	public List<VO> findByName(PK name);	// 경기장 이름
	public List<VO> findByDate(PK date);	// 경기 날짜
	public List<VO> findByMatch(PK match);	// 매치업
	

}
