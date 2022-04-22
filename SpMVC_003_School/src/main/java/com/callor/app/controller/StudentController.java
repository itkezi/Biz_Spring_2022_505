package com.callor.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.app.domain.StudentVO;
import com.callor.app.service.StudentService;

@Controller // 컴포넌트가 됨 = bean(객체)
public class StudentController {

	private final StudentService stService;

	// [해지 주석]
	// @가 붙어있는 class는 new를 이용해서 생성자를 호출하지 않는다 ( = new StudentServiceImpl 안쓴다는 말)
	// (StudentServiceImpl이 @Service를 달고있기 때문이다)
	// 선언만 해놓으면 bean이 된 @controller를 dispatcher가 가져다줌(Spring Container가 해준다?) = IOC
	// : 제어의 역전
	//
	// [쌤 주석]
	// Controller에서 Service Interface를 상속받은 클래스 중에 한 가지를 사용하고자 한다.
	// 전통적인 java에서는 : 인터페이스 객체 = new 클래스생성자()와 같이 사용한다.
	//
	// Spring framework project에서는 private final 인터페이스 객체와 같이 선언하고 임의 생성자를 만들어
	// argument로 전달받아
	// 객체에 대입하는 코드를 만들어 둔다
	//
	// 그러면 미리 bean으로 생성되어 있는 객체들 중에 자동으로 주입이 된다
	public StudentController(StudentService stService) {
		this.stService = stService;
	}

	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String list(Model model) {
		
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("STUDENTS", stList);
		
		return "student/list_view";
	}
	
	@RequestMapping(value="student/detail", method=RequestMethod.GET)
	public String detail(String stNum, Model model) {
		
		StudentVO stVO =  stService.findById(stNum);
		model.addAttribute("STUDENTS",stVO);
		
		return "student/detail";
	}
	
	@RequestMapping(value = "/student/insert", method = RequestMethod.GET)
	public String insert() {
		return "student/insert";
	}

}
