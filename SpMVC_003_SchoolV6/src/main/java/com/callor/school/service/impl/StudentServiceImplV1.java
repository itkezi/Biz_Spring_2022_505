package com.callor.school.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.callor.school.dao.StudentDao;
import com.callor.school.model.StudentVO;
import com.callor.school.service.StudentService;

import lombok.extern.slf4j.Slf4j;


// StudentService stService = new StudentServiceImplV1();
// @slf4j Annotationm을 부착함으로써 다음 코드를 lombok이 대신 만들어준다
// private static final Logger log = LoggerFactory.getLogger(StudentServiceImplV1.class);  
@Slf4j
@Service("stServiceV1")
public class StudentServiceImplV1 implements StudentService{
	
	
	// 생성자 주입
	private final StudentDao stDao;
	public StudentServiceImplV1(StudentDao stDao) {
		this.stDao = stDao;
	}

	@Override
	public List<StudentVO> selectAll() {
		
		return stDao.selectAll();
	}

	@Override
	public StudentVO findByNum(String st_num) {
		return stDao.findByNum(st_num);
	}

	@Override
	public int insert(StudentVO stVO) {
		int count = stDao.insert(stVO);
		return count;
	}

	@Override
	public int update(StudentVO stVO) {
		int count = stDao.update(stVO);
		return count;
	}

	@Override
	public int delete(String st_num) {
		int count = stDao.delete(st_num);
		return count;
	}

}
