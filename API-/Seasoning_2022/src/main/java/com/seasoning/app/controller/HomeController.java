package com.seasoning.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/football", method = RequestMethod.GET)
	public String football() {
		return "football/fb-seoul";
	}
	
	@RequestMapping(value="/baseball", method = RequestMethod.GET)
	public String baseball() {
		return "baseball/bb-dusan";
	}
	
	@RequestMapping(value="/volleyball", method = RequestMethod.GET)
	public String volleyball() {
		return "football/fb-seoul";
	}
	

}
