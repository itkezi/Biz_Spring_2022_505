package com.itkezi.letterbunker.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itkezi.letterbunker.service.NaverService;
import com.itkezi.letterbunker.model.NaverVO;

@RequestMapping(value="/book")
@Controller
public class BookController {
	
	private final NaverService naverService;
	
	public BookController(NaverService naverService) {
		this.naverService = naverService;
	}
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public String getBooks(String title, Model model){
		String queryString = naverService.queryString("BOOK", title);
		List<NaverVO> bookList = naverService.getNaver(queryString);
		model.addAttribute("BOOKS", bookList);
		return "naver/book_search";
	}

}
