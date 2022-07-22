package com.callor.naver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/books")
public class BooksController {
	
	@RequestMapping(value={"/", ""})
	public String home() {
		/*
		 * return "문자열" 형식은 명시적으로 어떤 JSP 파일을 rendering 할 것인지 알려주는 것이다
		 * 현재 method를 요청한 URL에 대하여 JSP를 명시적으로 전달한다
		 */
		return "books/list";
	}

	@RequestMapping(value="/list")
	public String list() {
		/*
		 * return null 형식은 암시적으로 어떤 JSP 파일을 rendering 할 것인지 알려주는 것이다
		 * 현재 method 요청한 URL이 명시적으로 명확할 경우 null을 return하면
		 * String에서 자체적으로 폴더/파일 형식으로 구성해준다
		 */
		return null;
	}

}
