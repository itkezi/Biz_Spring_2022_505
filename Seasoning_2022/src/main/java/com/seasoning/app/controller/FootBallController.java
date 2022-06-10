package com.seasoning.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seasoning.app.model.FootBallScheduleVO;
import com.seasoning.app.service.FootBallService;

@RequestMapping(value = "/football")
@Controller
public class FootBallController {

	@Autowired
	private FootBallService fbService;

//	private final FootBallService fbService;
//
//	public FootBallController(FootBallService fbService) {
//		this.fbService = fbService;
//	}

	@RequestMapping(value = { "/", "" })
	public String home() {
		return "football/football-seoul";
	}

	@RequestMapping(value = "/football-seoul")
	public String seoul() {

		return null;
	}

//	@RequestMapping(value = "/fb-schedule")
//	public String schedule(Model model) {
//
//		return "football/football-seoul";
//	}

	@RequestMapping(value = "/fb-schedule")
	public String schedule(Model model) {
		List<FootBallScheduleVO> fblist = fbService.selectAll();

		model.addAttribute("FB", fblist);

		return null;
	}

}
