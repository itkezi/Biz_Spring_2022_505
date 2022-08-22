package com.itkezi.booksbooks.service;

import java.util.List;

import com.itkezi.booksbooks.model.NaverBookVO;

public interface NaverService {
	
	public String queryString(String cat, String search);
	public String getJsonString(String queryString);
	public List<NaverBookVO> getNaverBook(String queryString);

}
