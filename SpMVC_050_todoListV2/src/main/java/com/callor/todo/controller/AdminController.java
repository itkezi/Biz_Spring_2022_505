package com.callor.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.UserVO;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@RequestMapping(value={"/home"},method=RequestMethod.GET)
	public String home(UserVO userVO) {
		
		return null;
	}

}
