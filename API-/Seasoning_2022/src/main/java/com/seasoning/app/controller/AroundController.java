package com.seasoning.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seasoning.app.model.AroundVO;
import com.seasoning.app.service.AroundService;

@RequestMapping(value="/around")
@Controller
public class AroundController {

	private final AroundService aroundService;

	public AroundController(AroundService aroundService) {
		this.aroundService = aroundService;
	}
	
	//TODO 대구
	@RequestMapping(value="/deagu", method=RequestMethod.GET)
	public String getDeaguAround(Model model) throws IOException{
		
		List<AroundVO> AroundList = aroundService.getDeaguAround();
		
		model.addAttribute("DEAGUAROUND",AroundList);
		
		return "/around/deagu";
		
	}
}
