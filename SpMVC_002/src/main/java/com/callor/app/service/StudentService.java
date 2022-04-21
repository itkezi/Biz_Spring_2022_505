package com.callor.app.service;

import com.callor.app.domain.StudentVO;

// 인터페이스엔 골뱅이(키워드) 붙이면 안됨
public interface StudentService {

	// 학생 데이터 추가하기
	public int insert(StudentVO studentVO);
	
	// 전체 리스트 가져오기
	public StudentVO[] selectAll();
	
	// 특정한 데이터 가져오기
	public StudentVO findById(String stNum);
	
}
