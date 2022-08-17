package com.itkezi.letterbunker.service;

import java.util.List;

import com.itkezi.letterbunker.model.NaverVO;

public interface NaverService {

	public String queryString(String cat, String search);
	public List<NaverVO> getNaver(String queryString);
	
}
