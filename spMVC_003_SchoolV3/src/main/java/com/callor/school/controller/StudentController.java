package com.callor.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.school.domain.StudentVO;
import com.callor.school.service.StudentService;

// Controller level에서 @RequestMapping을 설정하면
// Controller의 mapping과 method의 mapping이 서로 연결되어 RequestMapping을 구성한다 
// localhost:8080/school/student : StudentController의 Mapping이 연결
// localhost:8080/school/student/list : StudentController#list()의 Mapping이 연결
@RequestMapping(value ="/student")
@Controller
public class StudentController {
	
	// Dependency inject 중 생성자 injection ( 생성자에서 값을 초기화한다)
	private final StudentService stService;
	public StudentController(StudentService stService) {
		this.stService = stService;
	}

	// return type이 String type일 경우 null을 쓸 수 있다.
	// RequestMapping value값으로 찾아가는 것 ( 이름을 일치해야만 가능한 spring 기술 )
	//
	// return type이 String type인 method인 경우
	// null 값을 return 하면 Request Path와 같은 jsp 파일을 찾아서 rendering을 수행한다
	// 단, @ResponseBody 설정이 없어야 한다.
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		// RequestMapping이 /Student/list이기 때문에
		// return "Student/list"와 같다
		model.addAttribute("ST_LIST", stService.selectAll());
		return null;
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input() {
		return null;
		
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(String stNum, Model model) {
		
		StudentVO stVO = stService.findByStNum(stNum);
		model.addAttribute("ST", stVO);
		
		return null;
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String update() {
		return null;
	}
}

