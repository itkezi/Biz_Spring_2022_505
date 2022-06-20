package com.seasoning.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seasoning.app.model.AroundVO;
import com.seasoning.app.model.FootBallScheduleVO;
import com.seasoning.app.model.LocationVO;
import com.seasoning.app.service.AroundService;
import com.seasoning.app.service.FoodLocationService;
import com.seasoning.app.service.FootBallService;
import com.seasoning.app.service.LodgmentLocationService;
import com.seasoning.app.service.TourLocationService;

@RequestMapping(value = "/football")
@Controller
public class FootBallController {

	@Autowired
	private FootBallService fbService;
	@Autowired
	private AroundService aroundService;
	@Autowired
	private TourLocationService tourService;
	@Autowired
	private FoodLocationService foodService;
	@Autowired
	private LodgmentLocationService lodgmentService;

	@RequestMapping(value = { "/", "" })
	public String home() {
		return "football/fb-seoul";
	}

	@RequestMapping(value = "/fb-seoul")
	public String seoul(Model model) throws IOException {

		List<FootBallScheduleVO> fblist = fbService.selectAll();
		List<AroundVO> AroundList = aroundService.getSeoulAround();
		// 서울
		List<LocationVO> SeoulTourList = tourService.getSeoul_TourLocation();
		List<LocationVO> SeoulFoodList = foodService.getSeoul_FoodLocation();
		List<LocationVO> SeoulLodgmentList = lodgmentService.getSeoul_LodgmentLocation();
		
		//대구
		List<LocationVO> DeaguTourList = tourService.getDeagu_TourLocation();
		List<LocationVO> DeaguFoodList = foodService.getDeagu_FoodLocation();
		List<LocationVO> DeaguLodgmentList = lodgmentService.getDeagu_LodgmentLocation();

		model.addAttribute("FOOTBALL", fblist);
		model.addAttribute("SEOULaround",AroundList);
		//서울
		model.addAttribute("SEOULtour",SeoulTourList);
		model.addAttribute("SEOULfood",SeoulFoodList);
		model.addAttribute("SEOULlodgment",SeoulLodgmentList);
		//대구
		model.addAttribute("SEOULtour",DeaguTourList);
		model.addAttribute("SEOULfood",DeaguFoodList);
		model.addAttribute("SEOULlodgment",DeaguLodgmentList);
		return null;
	}

	@RequestMapping(value = "/fb-daegu")
	public String daegu(Model model) throws IOException {

		List<FootBallScheduleVO> fblist = fbService.selectAll();
		List<AroundVO> AroundList = aroundService.getDeaguAround();
		
		model.addAttribute("FOOTBALL", fblist);
		model.addAttribute("DEAGUAROUND",AroundList);
		
		return null;
	}

	@RequestMapping(value = "/fb-gangwon1")
	public String gangwon1(Model model)throws IOException {

		List<FootBallScheduleVO> fblist = fbService.selectAll();
		List<AroundVO> AroundList = aroundService.getGangwon1Around();

		model.addAttribute("FOOTBALL", fblist);
		model.addAttribute("GANGWON1ROUND",AroundList);

		return null;
	}

	@RequestMapping(value = "/fb-gangwon2")
	public String gangwon2(Model model) throws IOException {

		List<FootBallScheduleVO> fblist = fbService.selectAll();
		List<AroundVO> AroundList = aroundService.getGangwon2Around();

		model.addAttribute("FOOTBALL", fblist);
		model.addAttribute("GANGWON2ROUND",AroundList);

		return null;
	}

	@RequestMapping(value = "/fb-gimcheon")
	public String gimcheon(Model model) throws IOException {

		List<FootBallScheduleVO> fblist = fbService.selectAll();
		List<AroundVO> AroundList = aroundService.getGimcheonAround();

		model.addAttribute("FOOTBALL", fblist);
		model.addAttribute("GIMCHEONAROUND",AroundList);

		return null;
	}

	@RequestMapping(value = "/fb-incheon")
	public String incheon(Model model) throws IOException {

		List<FootBallScheduleVO> fblist = fbService.selectAll();
		List<AroundVO> AroundList = aroundService.getIncheonAround();

		model.addAttribute("FOOTBALL", fblist);
		model.addAttribute("INCHEONAROUND",AroundList);
		return null;
	}

	@RequestMapping(value = "/fb-jeju")
	public String jeju(Model model) throws IOException {

		List<FootBallScheduleVO> fblist = fbService.selectAll();
		List<AroundVO> AroundList = aroundService.getJejuAround();

		model.addAttribute("FOOTBALL", fblist);
		model.addAttribute("JEJUAROUND",AroundList);

		return null;
	}

	@RequestMapping(value = "/fb-jeonbuk")
	public String jeonbuk(Model model) throws IOException {

		List<FootBallScheduleVO> fblist = fbService.selectAll();
		List<AroundVO> AroundList = aroundService.getJeonbukAround();

		model.addAttribute("FOOTBALL", fblist);
		model.addAttribute("JEONBUKAROUND",AroundList);
		
		return null;
	}

	@RequestMapping(value = "/fb-pohang")
	public String pohang(Model model) throws IOException {

		List<FootBallScheduleVO> fblist = fbService.selectAll();
		List<AroundVO> AroundList = aroundService.getPohangAround();
		
		model.addAttribute("FOOTBALL", fblist);

		return null;
	}

	@RequestMapping(value = "/fb-seongnam")
	public String seongnam(Model model) throws IOException {

		List<FootBallScheduleVO> fblist = fbService.selectAll();
		List<AroundVO> AroundList = aroundService.getSeongnamAround();

		model.addAttribute("FOOTBALL", fblist);
		model.addAttribute("SEONGNAMAROUND",AroundList);

		return null;
	}

	@RequestMapping(value = "/fb-suwon_ss")
	public String suwon_ss(Model model) throws IOException {

		List<FootBallScheduleVO> fblist = fbService.selectAll();
		List<AroundVO> AroundList = aroundService.getSuwan_ssAround();

		model.addAttribute("FOOTBALL", fblist);
		model.addAttribute("SUWONssAROUND",AroundList);

		return null;
	}

	@RequestMapping(value = "/fb-suwon")
	public String suwon(Model model) throws IOException {

		List<FootBallScheduleVO> fblist = fbService.selectAll();
		List<AroundVO> AroundList = aroundService.getSuwonAround();

		model.addAttribute("FOOTBALL", fblist);
		model.addAttribute("SUWONAROUND",AroundList);

		return null;
	}

	@RequestMapping(value = "/fb-ulsan")
	public String ulsan(Model model) throws IOException {

		List<FootBallScheduleVO> fblist = fbService.selectAll();
		List<AroundVO> AroundList = aroundService.getUlsanAround();

		model.addAttribute("FOOTBALL", fblist);
		model.addAttribute("ULSANAROUND",AroundList);
		
		return null;
	}

}
