package com.callor.todo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	

	
	@RequestMapping(value={"/login"}, method=RequestMethod.GET)
	public String login() {
		return null;
	}
	
	@RequestMapping(value={"/join"}, method=RequestMethod.GET)
	public String join() {
		return "/user/join";
	}
	
	@RequestMapping(value={"/join"}, method=RequestMethod.POST)
	public String join(UserVO userVO) {
		
		// 문자열이어야 하기 때문에 toString 사용
		log.info(userVO.toString());
		
		// 문자열과 결합할 경우엔 toString 생략
		log.info("회원가입 데이터 : {}", userVO);

		// 값을 여러번 나열할 경우
		// log.info("회원가입 데이터 : {} {}", userVO, userVO);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String mypage() {
		
		
		return "user/mypage";
	}

}
