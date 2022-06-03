package com.callor.naver.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.service.BookService;
import com.callor.naver.service.NaverService;
import com.callor.naver.service.exec.NaverBookServiceEx;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Qualifier(QualifierConfig.SERVICE.BOOKS_V2)
	private final BookService bookService;
	private final NaverService naverService;

	public HomeController(@Qualifier(QualifierConfig.SERVICE.NAVER_V2)  NaverService naverService, BookService bookService) {
		this.bookService = bookService;
		this.naverService = naverService;
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping(value= {"/",""}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String home(String cat, String search, Model model) {
		
		log.debug("카테고리 : " + cat);
		log.debug("검색어 : {}", search);
		
		String queString = naverService.queryString(cat, search);
		
		List<Object> bookList2 = naverService.getNaver(queString);
		
		model.addAttribute("BOOKS", bookList2);
		
		List<BookVO> bookList = bookService.selectAll();

		// bookList에 담긴 데이터를 BOOKS 이름으로 변수에 담아 JSP 파일로 보내겠다
		model.addAttribute("BOOKS", bookList);
		
		return null;
		
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
	
	
	@RequestMapping(value="/book/list")
	public String bookList() {
		return "book/list";
	}
	
	
	@RequestMapping(value="/book_add")
	public String bookadd() {
		return "book_add";
	}
}
