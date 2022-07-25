package com.callor.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.app.domain.StudentVO;
import com.callor.app.service.StudentService;

@Service // 컴포넌트가 됨 = bean(객체)
public class StudentServiceImplV1 implements StudentService {

	// Web Application 에서는 Service 클래스의 클래스 영역에 변수를 선언하지 않는다.
	
	// TODO 학생 데이터를 추가하기 
	@Override
	public int insert(StudentVO studentVO) {
		return 0;
	}

	// TODO 전체 데이터 가져오기
	@Override
	public List<StudentVO> selectAll() {
		List<StudentVO> stList = new ArrayList<>();
		
		StudentVO stVO = new StudentVO();
		stVO.setStNum("00001");
		stVO.setStName("홍길동");
		stVO.setStDept("컴공과");
		stVO.setIntGrade(3);
		stVO.setStAddr("서울특별시");
		stList.add(stVO);
		
		// 새로 new해주지 않으면 저장 **주소는 그대로**인채 안의 데이터만 갈아끼우기 때문에
		// 마지막에 입력된 데이터로 이전 데이터들이 덮어씌워진다
		stVO = new StudentVO();
		stVO.setStNum("00002");
		stVO.setStName("이몽룡");
		stVO.setStDept("전자과");
		stVO.setIntGrade(2);
		stVO.setStAddr("전라북도 익산시");
		stList.add(stVO);

		stVO = new StudentVO();
		stVO.setStNum("00003");
		stVO.setStName("성춘향");
		stVO.setStDept("법학과");
		stVO.setIntGrade(1);
		stVO.setStAddr("전라북도 남원시");
		stList.add(stVO);

		stVO = new StudentVO();
		stVO.setStNum("00004");
		stVO.setStName("임꺽정");
		stVO.setStDept("체육과");
		stVO.setIntGrade(4);
		stVO.setStAddr("함경북도 함흥시");
		stList.add(stVO);
		
		stVO = new StudentVO();
		stVO.setStNum("00005");
		stVO.setStName("장보고");
		stVO.setStDept("해양생물학과");
		stVO.setIntGrade(1);
		stVO.setStAddr("전라남도 진도군");
		stList.add(stVO);
		
		return stList;
	}

	// TODO 학생 데이터 ID로 조회하기
	@Override
	public StudentVO findById(String stNum) {
		return null;
	}


}
