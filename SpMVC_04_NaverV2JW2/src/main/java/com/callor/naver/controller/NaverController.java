package com.callor.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.service.NaverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/naver")
@Controller
public class NaverController {
	private final NaverService naverService;

	public NaverController(@Qualifier(QualifierConfig.SERVICE.NAVER_V2) NaverService naverService) {
		this.naverService = naverService;
	}

//	@RequestMapping(value = "/books", method = RequestMethod.GET)
//	public String getBooks(String title, Model model) {
//		String queryString = naverService.queryString("BOOK", title);
//
//		List<Object> bookList = naverService.getNaver(queryString);
//
//		model.addAttribute("BOOKS", bookList);
//
//		return "naver/book_search";
//	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String home() {
		return "naver/search";
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String home(String cat, String search, Model model) {
		log.debug("카테고리 : " + cat);
		log.debug("검색어 : {}", search);

		String queryString = naverService.queryString("BOOK", search);

		if (cat.equals("NEWS")) {
			queryString = naverService.queryString("NEWS", search);
		} else if (cat.equals("MOVIE")) {
			queryString = naverService.queryString("MOVIE", search);
		}

		List<Object> bookList = naverService.getNaver(queryString);

		model.addAttribute("BOOKS", bookList);

		return "naver/book_search";
	}

}
