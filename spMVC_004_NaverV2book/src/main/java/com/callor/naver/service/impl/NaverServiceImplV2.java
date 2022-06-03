package com.callor.naver.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.naver.config.NaverConfig;
import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.NaverChannel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifierConfig.SERVICE.NAVER_V2)
public class NaverServiceImplV2 extends NaverServiceImpl {
	
	@Override
	public String queryString(String cat, String search) {
		
		
		// http://open.../book.json
		String queryString = NaverConfig.NAVER_BOOK_XML_URL;

		String encodeSearch = null;
		try {
			encodeSearch = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.debug("URL Encoding 오류 발생");
			return null;
		}
		queryString += String.format("?query=%s", encodeSearch);
		log.debug("query : " + queryString);
		
		queryString += String.format("&display=%d", 10);
		
		return queryString;
		
		
	}

	// String cat와 queryString() method를 상속받는다

	@Override
	public List<Object> getNaver(String queryString) {

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

		// XML 데이터 타입으로 받겠다
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

		// headers에 추가된 정보를 Entity type의 객체로 변환하기
		HttpEntity<String> entity = new HttpEntity<String>("parameter", headers);

		/*
		 * NaverParent는 List<VO> 타입의 items 변수를 갖는데 여기에서 VO type을 BookVO로 확정지어 준다
		 */

		RestTemplate restTemp = new RestTemplate();
		/*
		 * VO가 아닌 String 형으로 수신하기
		 */
			ResponseEntity<String> resData = null;
			resData = restTemp.exchange(restURI, HttpMethod.GET, entity, String.class);
			
			System.out.println("=".repeat(100));
			System.out.println(resData.getBody());
			System.out.println("=".repeat(100));
			
			String xmlString = resData.getBody();
			
			// xml 문자열을 VO 객체로 변환하기 위한 도구
			ObjectMapper xmlMapper = new XmlMapper();
			
			try {
				NaverChannel naverChannel = xmlMapper.readValue(xmlString, NaverChannel.class);
				log.debug(naverChannel.channel.item.toString());
				return naverChannel.channel.item;
			} catch (JsonProcessingException e) {

			}
			
			
		//			return resData.getBody().items;
			return null;

		//		return resData.getBody().items;
		//		resData = restTemp.exchange(restURI, HttpMethod.GET, entity, NaverParent<BookVO>);

		// Naver에서 받은 데이터는 resData의 body에 담겨있다
		// body 데이터를 get하여 그 데이터 중에서 items만 추출하여
		// controller로 return
	}

}
