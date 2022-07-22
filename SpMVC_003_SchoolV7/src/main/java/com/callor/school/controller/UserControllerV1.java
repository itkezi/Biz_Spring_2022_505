package com.callor.school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.school.model.UserVO;
import com.callor.school.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @RequestMapping(value = "/user")
public class UserControllerV1 {

	private final UserService userService;

	public UserControllerV1(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return null;
	}

	/*
	 * 1. login.form 에서 username과 password 받기 2. userVO에 담겨서 받게 된다 3. userVO
	 * UserService.login에게 전달한다 4. UserService.login() method는 username과 password 검사
	 * 5. 정삭적인 (username, password 가 일치) 정보이면 나머지 user 정보를 userVO에 담아서 return 만약
	 * 정상적인 사용자가 아니면 null 을 return 6. Controller.login.POST method에는 HttpSession
	 * 클래스를 매개변수로 설정된다 7. 정상 사용자 정보이면(userVO가 null이 아니면) setAttribute() method를 사용하여
	 * 사용자 정보를 변수에 setting 한다 8. 정상 사용자가 아니면 removeAttribute() method를 사용하여 변수를 제거해
	 * 버린다
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO userVO, HttpSession session, Model model) {
		// 로그인 폼에서 입력한 username, password는 userVO에 담겨 이곳에 도착한다
		log.debug(userVO.toString());
		
		// Server와 view 사이에서 약속된 Protocol을 사용하기 위하여 변수를 선언하고 
		String loginMessage = null;
		// 로그인 폼에서 전송된 데이터 중 username으로 findByI() 즉 SelectOne(username)을 실행한다
		// 그리고 결과를 loginUserVO에 담는다
		// 만약 username 정보가 user table에 없으면 결과는 null이고, 
		// 정보가 있으면 관련데이터가 포함된 vo가 만들어진다 
		UserVO loginUserVO = userService.findById(userVO.getUsername());
		
		// username이 가입된 적이 없을 때
		if(loginUserVO == null) {
			// 가입된 적이 없다는 Key Word를 생성하고
			loginMessage = "USERNAME FAIL";
		} else
		
		// username은 있는데 password가 다를 경우
		if( !loginUserVO.getPassword().equals(userVO.getPassword())) {
			// 비밀번호가 잘못되었다는 Key Word를 생성하고
			loginMessage = "PASSWORD FAIL";
		}

		// 로그인 되었는지 그렇지 않은지 세션에 세팅
		if (loginMessage == null) {
			session.setAttribute("USER", loginUserVO);
		} else {
			session.removeAttribute("USER");
		}

		// view로 보낼 message Protocol을 setting
		model.addAttribute("LOGIN_MESSAGE", loginMessage);
		
		return "user/login_ok";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.removeAttribute("USER");

		/*
		 * redirect: 로그아웃이 끝나면 web browser의 주소창에 /user/login 을 입력하고 Enter를 눌러라
		 */
		return "redirect:/user/login";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {

		/*
		 * 이 method를 요청하는 url은 /user/join 이다
		 * 
		 * return null을 실행하면 return user/join을 실행한 것과 같다 views/user/join.jsp를 rendering
		 * 하라는 의미
		 */
		return null;
	};

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVO) {

		log.debug(userVO.toString());
		userService.join(userVO);

		/*
		 * return "문자열" : Forwarding => views/문자열.jsp를 rendering하라
		 * 
		 * return "redirect:/url" : pass, toss, redirect => 서버의 localhost:8080/url을 다시
		 * request 하라 => web browse 주소창에 localhost:8080/url을 입력하고 Enter를 누르는 것과 같은 효과
		 */
		return "redirect:/user/login";
	}

	/*
	 * username 중복검사를 하기 위해 보통 다음같은 요청을 수행한다 /user/idcheck?username=callor
	 * 
	 * fetch(`${rootPath}/user/idcheck/${username.value}`) 만약 username에 callor를
	 * 입력했으면 /user/idcheck/callor 처럼 요청 URL 만들어서 요청을 수행하라
	 * 
	 * id를 email주소로 사용할 때 PathVarriable로 받을 경우 dot(.) 이후의 문자열을 잘라버리는 현상이 있다 이때는
	 * 정규식(Rexp)를 사용하여 dot(.) 이후 문자열을 포함하여 변수에 저장하도록 변수를 수정 {username:.+} 형식으로 지정한다
	 */
	@ResponseBody
	@RequestMapping(value = "/idcheck/{username:.+}", method = RequestMethod.GET)
	public String idcheck(@PathVariable String username) {

		UserVO userVO = userService.findById(username);

		// if(username.equalsIgnoreCase(userVO.getUsername()))
		// 아래와 같은 코드
		// if(userVO.getUsername().equalsIgnoreCase(username)) {
		// return "fail";
		// } else {
		// return "ok";
		// }
		if (userVO == null) {
			return "ok";
		} else {
			return "fail";
		}

	};

}
