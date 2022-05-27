package com.callor.school.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.school.model.UserVO;
import com.callor.school.pesistance.UserDao;
import com.callor.school.service.UserService;

/*
 * UserServiceImplV1 클래스를 Component(bean)로 등록하기
 * */
@Service
public class UserServiceImplV1 implements UserService{
	
	
	private final UserDao userDao;
	
	public UserServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserVO login(UserVO userVO) {
		
		String username = userVO.getUsername();
		String password = userVO.getPassword();
		
		if(username.equalsIgnoreCase("itkezi")
			&& password.equals("12341234")){
			userVO.setName("이케지");
			userVO.setRole("ADMIN");
			userVO.setEmail("itkezi@naver.com");
		} else {
			userVO = null;
		}
		return userVO;
	}

	/*
	 * 회원가입 처리
	 * 1. 최초 회원가입자는 ADMIN role을 부여하기
	 * 2. 두 번째 이후 회원가입자는 USER role을 부여하기
	 */
	@Override
	public UserVO join(UserVO userVO) {
		
		// 1. user table에 데이터가 있는지 확인하기 위하여 전체 데이터를 select 하기
		List<UserVO> userList = userDao.selectAll();
		// 만약 user table에 데이터가 없으면 null return 한다
		if(userList == null || userList.size() < 1) {
			// 데이터가 없으면 최초 가입자이므로 role(권한)을 ADMIN(관리자)로 부여
			userVO.setRole("ADMIN");
		} else {
			userVO.setRole("USER");
		}
		
		userDao.insert(userVO);
		return null;
	}

	@Override
	public List<UserVO> selectAll() {
		return null;
	}

	@Override
	public UserVO findById(String id) {
		return userDao.findById(id);
	}

	@Override
	public int insert(UserVO vo) {
		return 0;
	}

	@Override
	public int update(UserVO vo) {
		return 0;
	}

	@Override
	public int delete(UserVO id) {
		return 0;
	}

}
