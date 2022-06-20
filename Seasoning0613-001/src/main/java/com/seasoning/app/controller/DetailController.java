package com.seasoning.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seasoning.app.model.CommonDetailVO;
import com.seasoning.app.model.FoodDetailVO;
import com.seasoning.app.model.LodgmentDetailVO;
import com.seasoning.app.model.TourDetailVO;
import com.seasoning.app.service.DetailService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping(value="/detail")
@Controller
public class DetailController {
	
	@Autowired
	public DetailService detailService;
	
	@RequestMapping(value="/detail")
	public String detail(Model model) throws IOException {
		FoodDetailVO foodDetailVO = detailService.getFoodDetail() ;
		CommonDetailVO CommonDetailVO = detailService.getFoodCommonDetail();
		
		model.addAttribute("FOODDETAIL",foodDetailVO);
		model.addAttribute("COMMONDETAIL",CommonDetailVO);
		return "/detail/detail";
	}
	
	@RequestMapping(value ="/tour_detail")
	public String tour_detail(Model model) throws IOException{
		
		TourDetailVO TourDetailVO = detailService.getTourDetail() ;
		CommonDetailVO CommonDetailVO = detailService.getTourCommonDetail();
		
		model.addAttribute("TOURDETAIL",TourDetailVO);
		model.addAttribute("COMMONDETAIL",CommonDetailVO);
		
		
		return "/detail/tour_detail";
	}
	
	@RequestMapping(value ="/food_detail")
	public String food_detail(Model model) throws IOException{
		
		FoodDetailVO foodDetailVO = detailService.getFoodDetail() ;
		CommonDetailVO CommonDetailVO = detailService.getFoodCommonDetail();
		
		model.addAttribute("FOODDETAIL",foodDetailVO);
		model.addAttribute("COMMONDETAIL",CommonDetailVO);
		
		
		return "/detail/food_detail";
	}
	
	@RequestMapping(value ="/lodgment_detail")
	public String lodgment_detail(Model model) throws IOException{
		
		LodgmentDetailVO lodgmentDetailVO = detailService.getLodgmentDetail();
		CommonDetailVO CommonDetailVO = detailService.getLodgmentCommonDetail();
		
		model.addAttribute("LODGMENTDETAIL",lodgmentDetailVO);
		model.addAttribute("COMMONDETAIL",CommonDetailVO);
		
		return "/detail/lodgment_detail";
	}
	

}
