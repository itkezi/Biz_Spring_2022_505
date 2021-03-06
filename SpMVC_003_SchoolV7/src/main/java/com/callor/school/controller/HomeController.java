package com.callor.school.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.debug("반갑습니다 여기는 home입니다");
		return "home";
	}
	
	@RequestMapping(value = "/tour", method = RequestMethod.GET)
	public String tour(Locale locale, Model model) {
		log.debug("TOUR TEST");
		return "/tour";
	}
	
}
