package com.itkezi.letterbunker.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.itkezi.letterbunker.config.NaverConfig;
import com.itkezi.letterbunker.model.NaverParent;
import com.itkezi.letterbunker.model.NaverVO;
import com.itkezi.letterbunker.service.NaverService;
import com.itkezi.letterbunker.service.ex.NaverServiceEx;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverServiceImplV1 extends NaverServiceEx implements NaverService{


	@Override
	public List<NaverVO> getNaver(String queryString) {
		
		URI restURI = null;
		try {
			restURI = new URI(queryString);
		} catch (URISyntaxException e) {
			log.debug("URI 문법오류");
		}
		
		
		// Http 프로토콜에 보안 정보를 세팅하여
		// Naver로 전송할 준비
		HttpHeaders headers = new HttpHeaders();
		headers.set(NaverConfig.HEADER.ID, NaverConfig.NAVER_CLIENT_ID);
		headers.set(NaverConfig.HEADER.SEC, NaverConfig.NAVER_CLIENT_SEC);
		
		// JSON 데이터 타입으로 받겠다
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		// headers에 추가된 정보를 Entity type의 객체로 변환하기 
		HttpEntity<String> entity = new HttpEntity<String>("parameter" , headers);
		
		ResponseEntity<NaverParent> resData = null;
		
		RestTemplate restTemp = new RestTemplate();
		
		resData = restTemp.exchange(restURI, HttpMethod.GET, entity, NaverParent.class);
		
		// Naver에서 받은 데이터는 resData의 body에 담겨있다
		// body 데이터를 get하여 그 데이터 중에서 items만 추출하여
		// controller로 return
		return resData.getBody().items;
	}
	
	

}