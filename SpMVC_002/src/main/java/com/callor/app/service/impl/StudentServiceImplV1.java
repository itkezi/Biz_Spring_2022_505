package com.callor.app.service.impl;

import org.springframework.stereotype.Service;

import com.callor.app.domain.StudentVO;
import com.callor.app.service.StudentService;

@Service // 컴포넌트가 됨 = bean(객체)
public class StudentServiceImplV1 implements StudentService {

	// TODO 학생 데이터를 추가하기 
	@Override
	public int insert(StudentVO studentVO) {
		return 0;
	}

	// TODO 전체 데이터 가져오기 
	@Override
	public StudentVO[] selectAll() {
		return null;
	}

	// TODO 학생 데이터 ID로 조회하기
	@Override
	public StudentVO findById(String stNum) {
		return null;
	}

}
