package com.itkezi.booksbooks.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itkezi.booksbooks.config.NaverConfig;
import com.itkezi.booksbooks.model.NaverBookVO;
import com.itkezi.booksbooks.service.impl.NaverServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final NaverServiceImpl naverService;

	public HomeController(NaverServiceImpl naverService) {
		this.naverService = naverService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getBooks(String title, Model model) {
		String queryString = naverService.queryString("BOOK", title);
		List<NaverBookVO> bookList = naverService.getNaverBook(queryString);
		model.addAttribute("BOOKS", bookList);
		return "/book_search";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String home() {
		return "/insert";
	}

	@ResponseBody
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String home(String title, Model model) {
		log.debug("도서명 : " + title);
		
		String queryString = naverService.queryString("BOOK", title);
		String resString = naverService.getJsonString(queryString);
		
		return resString;
	}
	
	@ResponseBody
	@RequestMapping(value="/{isbn}/result", method = RequestMethod.GET, produces = NaverConfig.APP_JSON)
	public Object book(@PathVariable("isbn") String isbn) {
		
		String queryString = naverService.queryString("BOOK", isbn);
		
		List<NaverBookVO> bookList = naverService.getNaverBook(queryString);
		
		return bookList.get(0);
		
	}
	
	
}
