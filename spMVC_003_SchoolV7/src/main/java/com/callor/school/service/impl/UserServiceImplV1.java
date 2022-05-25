package com.callor.school.service.impl;

import org.springframework.stereotype.Service;

import com.callor.school.model.UserVO;
import com.callor.school.servicel.UserService;

/*
 * UserServiceImplV1 클래스를 Component(bean)로 등록하기
 * */
@Service
public class UserServiceImplV1 implements UserService{

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

	@Override
	public UserVO join(UserVO userVO) {
		return null;
	}

}
