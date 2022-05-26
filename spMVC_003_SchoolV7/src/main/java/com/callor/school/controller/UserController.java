package com.callor.school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.school.model.UserVO;
import com.callor.school.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return null;
	}
	
	/*
	 * 1. login.form 에서 username과 password 받기
	 * 2. userVO에 담겨서 받게 된다
	 * 3. userVO UserService.login에게 전달한다
	 * 4. UserService.login() method는 username과 password 검사
	 * 5. 정삭적인 (username, password 가 일치) 정보이면 나머지 user 정보를 userVO에 담아서 return 만약 정상적인 사용자가 아니면 null 을 return
	 * 6. Controller.login.POST method에는 HttpSession 클래스를 매개변수로 설정된다
	 * 7. 정상 사용자 정보이면(userVO가 null이 아니면) setAttribute() method를 사용하여 사용자 정보를 변수에 setting 한다
	 * 8. 정상 사용자가 아니면 removeAttribute() method를 사용하여 변수를 제거해 버린다
	 */
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserVO userVO, HttpSession session) {
		log.debug(userVO.toString());
		
		userVO = userService.login(userVO);
		if(userVO == null) {
			session.removeAttribute("USER");
		} else {
			session.setAttribute("USER", userVO);
		}
		
		return null;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("USER");
		
		/*
		 * redirect:
		 * 로그아웃이 끝나면 web browser의 주소창에 /user/login 을 입력하고 Enter를 눌러라
		 */
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String join() {
		
		/*
		 * 이 method를 요청하는 url은
		 * /user/join 이다
		 * 
		 *  return null을 실행하면
		 *  return user/join을 실행한 것과 같다
		 *  views/user/join.jsp를 rendering 하라는 의미
		 */
		return null;
	};
	
	/*
	 * username 중복검사를 하기 위해 보통 다음같은 요청을 수행한다
	 * /user/idcheck?username=callor
	 *   
	 * fetch(`${rootPath}/user/idcheck/${username.value}`)
	 * 만약 username에 callor를 입력했으면
	 * /user/idcheck/callor 처럼 요청 URL 만들어서 요청을 수행하라
	 */
	@ResponseBody
	@RequestMapping(value="/idcheck/{username}", method=RequestMethod.GET)
	public String idcheck(@PathVariable("username")  String username) {
		if(username.equals("itkezi")) {
			return "fail";
		} else {
			return "ok";
		}
		
	};

}




