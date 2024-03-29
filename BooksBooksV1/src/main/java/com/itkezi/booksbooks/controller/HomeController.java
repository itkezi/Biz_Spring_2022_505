package com.itkezi.booksbooks.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itkezi.booksbooks.config.NaverConfig;
import com.itkezi.booksbooks.model.BookVO;
import com.itkezi.booksbooks.model.NaverBookVO;
import com.itkezi.booksbooks.service.BookService;
import com.itkezi.booksbooks.service.NaverService;
import com.itkezi.booksbooks.service.impl.NaverServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final NaverService naverService;
	
	private final BookService bookService;

	public HomeController(NaverServiceImpl naverService, BookService bookService) {
		this.naverService = naverService;
		this.bookService = bookService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Principal principal, Model model) {
		
		List<BookVO> bookList = bookService.findByUsername(principal.getName());
		
		model.addAttribute("BOOKS",bookList);
		
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

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String home(Principal principal,BookVO bookVO) {
		
		bookVO.setB_username(principal.getName());
		bookService.insert(bookVO);
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="/{isbn}/result", method = RequestMethod.GET, produces = NaverConfig.APP_JSON)
	public Object book(@PathVariable("isbn") String isbn) {
		
		String queryString = naverService.queryString("BOOK", isbn);
		
		List<NaverBookVO> bookList = naverService.getNaverBook(queryString);
		
		return bookList.get(0);
		
	}
	
	
}
