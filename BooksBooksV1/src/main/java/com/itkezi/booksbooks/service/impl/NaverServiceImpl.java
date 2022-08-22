package com.itkezi.booksbooks.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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

import com.itkezi.booksbooks.config.NaverConfig;
import com.itkezi.booksbooks.model.NaverBookVO;
import com.itkezi.booksbooks.model.NaverParent;
import com.itkezi.booksbooks.service.NaverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverServiceImpl implements NaverService{
	
	public String queryString(String cat, String search) {
		
		// http://open.../book.json
		String queryString = NaverConfig.NAVER_BOOK_URL;
		
		String encodeSearch = null;
		try {
			encodeSearch = URLEncoder.encode(search, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.debug("URL Encoding 오류 발생");
			return null;
		}
		queryString += String.format("?query=%s", encodeSearch);
		log.debug("query : " + queryString);
		
		queryString += String.format("&display=%d", 20);
		
		return queryString;
		
	} // queryString() end

	// queryString 전달받아 Naver에 데이터를 요청하고
	// 응답받은 JSON String을 return 하기
	public String getJsonString(String queryString) {
		
		// java.net.URL을 import
		URL url = null; 
		HttpURLConnection httpCon = null;
		
		// queryString(URL, 요청정보)를 사용하여
		// Network 통해서 보낼 데이터로 생성하기
		try {
			url = new URL(queryString);
			httpCon = (HttpURLConnection) url.openConnection();
			// GET 방식으로 요청한다
			httpCon.setRequestMethod("GET");
			
			httpCon.setRequestProperty(NaverConfig.HEADER.ID, NaverConfig.NAVER_CLIENT_ID);
			httpCon.setRequestProperty(NaverConfig.HEADER.SEC, NaverConfig.NAVER_CLIENT_SEC);
			
			// 네이버에게 queryString 정보를 보내고 response 해 줄 데이터가 있는지 먼저 확인한다
			int resCode = httpCon.getResponseCode();
			
			InputStreamReader is = null;
			BufferedReader buffer = null;

			// 네이버가 200코드를 보내면
			if(resCode == 200) {
				// 데이터를 받아올 통로를 연결하기
				is = new InputStreamReader(httpCon.getInputStream());
			} else {
				// 만약 200코드가 아니면
				// 오류 메시지를 받을 통로를 연결하기
				is = new InputStreamReader (httpCon.getErrorStream());
			}
			buffer = new BufferedReader(is);
			
			String retString ="";
			while(true) {
				String line = buffer.readLine();
				if(line == null) break;
				
				retString += line;
			}
			return retString;
			
		} catch (MalformedURLException e) {
			log.debug("Query String 문자열 오류");
			return null;
		} catch (IOException e) {
			log.debug("네트워크 연결을 할 수 없음");
			return null;
		}
		
	}


	@Override
	public List<NaverBookVO> getNaverBook(String queryString) {
		
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
