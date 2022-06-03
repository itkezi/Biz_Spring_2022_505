package com.callor.naver.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.naver.model.NaverBookVO;
import com.callor.naver.service.NaverService;
import com.callor.naver.service.exec.NaverBookServiceEx;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final NaverService naverService;
	
	public HomeController(NaverService naverService) {
		this.naverService = naverService;
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, String title) {
//		String queryString = naverService.queryString("BOOK", title);
//		List<NaverBookVO> bookList = naverService.getNaverBook(queryString);
//		model.addAttribute("BOOKS", bookList);
		
		List<NaverBookVO> bookList = null;
		bookList = NaverService.selectAll();
		model.addAttribute("BOOKS", bookList);
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String home(String title, Model model) {
		log.debug("도서명 : " + title);
		
		NaverBookServiceEx naverService = new NaverBookServiceEx();
		String queryString = naverService.queryString("BOOK", title);
		String resString = naverService.getJsonString(queryString);
		
		return resString;
	}
	
	
	
	@RequestMapping(value="/book_add")
	public String bookadd() {
		return "book_add";
	}
}
