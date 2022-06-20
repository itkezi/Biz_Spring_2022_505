package com.seasoning.app.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.seasoning.app.model.CommonDetailVO;
import com.seasoning.app.model.FoodDetailVO;
import com.seasoning.app.model.LodgmentDetailVO;
import com.seasoning.app.model.TourDetailVO;
import com.seasoning.app.service.DetailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DetailListServiceImpl implements DetailService{

	
	//TODO  관광지
	@Override
	public TourDetailVO getTourDetail() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
		String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro"; /*URL*/
		try {
			url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
			url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수 이거 필수값 아님 없애도 됨*/
			url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호 이거 필수값 아님 없애도 됨*/
			url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode("2629074", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("12", "UTF-8")); /*서비스명=어플명*/
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		//파일 읽어들이기
        URL realUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        log.debug("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
        //파일 읽어서 한줄씩 String에 저장하기
        String retString = "";
        String line;
        while ((line = rd.readLine()) != null) {
           retString += line;
        }
        rd.close();
        conn.disconnect();
        //System.out.println(retString.toString());
        
        
        //xml json으로 형변환
        JSONObject json = XML.toJSONObject(retString);
        String jsonStr = json.toString(4);
        log.debug(jsonStr);
        
       
        // JSONObject형식으로 지정
        JSONObject jObject = new JSONObject(jsonStr);
        
        //response 안으로
        JSONObject response = jObject.getJSONObject("response");
        log.debug(response.toString(4));
        
        // body 안으로
        JSONObject body = response.getJSONObject("body");
        log.debug(body.toString(4));
        
        //items 안으로
        JSONObject items = body.getJSONObject("items");
        log.debug(items.toString(4));
        
        //item 선택
        JSONObject item = items.getJSONObject("item");
        log.debug(item.toString(4));
      
        // VO에 저장
        Gson gson = new Gson();
        TourDetailVO vo = gson.fromJson(item.toString(), TourDetailVO.class);
        
        //값 지정해서 콘텐츠 아이디 뽑아버리기
        log.debug(vo.contentid);
        
        return vo;
	}
	
	//TODO 음식
	@Override
	public FoodDetailVO getFoodDetail() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
				String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro"; /*URL*/
				try {
					url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
					url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수 이거 필수값 아님 없애도 됨*/
					url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호 이거 필수값 아님 없애도 됨*/
					url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
					url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode("133324", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("39", "UTF-8")); /*서비스명=어플명*/
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				
				//파일 읽어들이기
		        URL realUrl = new URL(url);
		        HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Content-type", "application/json");
		        log.debug("Response code: " + conn.getResponseCode());
		        BufferedReader rd;
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		        }
		        
		        //파일 읽어서 한줄씩 String에 저장하기
		        String retString = "";
		        String line;
		        while ((line = rd.readLine()) != null) {
		           retString += line;
		        }
		        rd.close();
		        conn.disconnect();
		        //System.out.println(retString.toString());
		        
		        
		        //xml json으로 형변환
		        JSONObject json = XML.toJSONObject(retString);
		        String jsonStr = json.toString(4);
		        log.debug(jsonStr);
		        
		       
		        // JSONObject형식으로 지정
		        JSONObject jObject = new JSONObject(jsonStr);
		        
		        //response 안으로
		        JSONObject response = jObject.getJSONObject("response");
		        log.debug(response.toString(4));
		        
		        // body 안으로
		        JSONObject body = response.getJSONObject("body");
		        log.debug(body.toString(4));
		        
		        //items 안으로
		        JSONObject items = body.getJSONObject("items");
		        log.debug(items.toString(4));
		        
		        //item 선택
		        JSONObject item = items.getJSONObject("item");
		        log.debug(item.toString(4));
		      
		        // VO에 저장
		        Gson gson = new Gson();
		        FoodDetailVO vo = gson.fromJson(item.toString(), FoodDetailVO.class);
		        
		        //값 지정해서 콘텐츠 아이디 뽑아버리기
		        log.debug(vo.contentid);
		        
		        return vo;
	}

	@Override
	public LodgmentDetailVO getLodgmentDetail() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
				String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro"; /*URL*/
				try {
					url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
					url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수 이거 필수값 아님 없애도 됨*/
					url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호 이거 필수값 아님 없애도 됨*/
					url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
					url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode("1877477", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("32", "UTF-8")); /*서비스명=어플명*/
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				
				//파일 읽어들이기
		        URL realUrl = new URL(url);
		        HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Content-type", "application/json");
		        log.debug("Response code: " + conn.getResponseCode());
		        BufferedReader rd;
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		        }
		        
		        //파일 읽어서 한줄씩 String에 저장하기
		        String retString = "";
		        String line;
		        while ((line = rd.readLine()) != null) {
		           retString += line;
		        }
		        rd.close();
		        conn.disconnect();
		        //System.out.println(retString.toString());
		        
		        
		        //xml json으로 형변환
		        JSONObject json = XML.toJSONObject(retString);
		        String jsonStr = json.toString(4);
		        log.debug(jsonStr);
		        
		       
		        // JSONObject형식으로 지정
		        JSONObject jObject = new JSONObject(jsonStr);
		        
		        //response 안으로
		        JSONObject response = jObject.getJSONObject("response");
		        log.debug(response.toString(4));
		        
		        // body 안으로
		        JSONObject body = response.getJSONObject("body");
		        log.debug(body.toString(4));
		        
		        //items 안으로
		        JSONObject items = body.getJSONObject("items");
		        log.debug(items.toString(4));
		        
		        //item 선택
		        JSONObject item = items.getJSONObject("item");
		        log.debug(item.toString(4));
		      
		        // VO에 저장
		        Gson gson = new Gson();
		        LodgmentDetailVO vo = gson.fromJson(item.toString(), LodgmentDetailVO.class);
		        
		        //값 지정해서 콘텐츠 아이디 뽑아버리기
		        log.debug(vo.contentid);
		        
		        return vo;
	}
	
	//TODO 숙박 공통정보 조회
	@Override
	public CommonDetailVO getLodgmentCommonDetail() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
		String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon"; /*URL*/
		try {
			url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
			url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수 이거 필수값 아님 없애도 됨*/
			url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호 이거 필수값 아님 없애도 됨*/
			url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode("1877477", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("defaultYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("firstImageYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("addrinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스명=어플명*/
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		//파일 읽어들이기
        URL realUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        log.debug("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        
        //파일 읽어서 한줄씩 String에 저장하기
        String retString = "";
        String line;
        while ((line = rd.readLine()) != null) {
           retString += line;
        }
        rd.close();
        conn.disconnect();
        //System.out.println(retString.toString());
        
        
        //xml json으로 형변환
        JSONObject json = XML.toJSONObject(retString);
        String jsonStr = json.toString(4);
        log.debug(jsonStr);
        
       
        // JSONObject형식으로 지정
        JSONObject jObject = new JSONObject(jsonStr);
        
        //response 안으로
        JSONObject response = jObject.getJSONObject("response");
        log.debug(response.toString(4));
        
        // body 안으로
        JSONObject body = response.getJSONObject("body");
        log.debug(body.toString(4));
        
        //items 안으로
        JSONObject items = body.getJSONObject("items");
        log.debug(items.toString(4));
        
        //item 선택
        JSONObject item = items.getJSONObject("item");
        log.debug(item.toString(4));
      
        // VO에 저장
        Gson gson = new Gson();
        CommonDetailVO vo = gson.fromJson(item.toString(), CommonDetailVO.class);
        
        //값 지정해서 콘텐츠 아이디 뽑아버리기
        //log.debug(vo.contentid);
        
        return vo;
	}
	
	//TODO 관광 공통정보 조회
	@Override
	public CommonDetailVO getTourCommonDetail() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
				String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon"; /*URL*/
				try {
					url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
					url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수 이거 필수값 아님 없애도 됨*/
					url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호 이거 필수값 아님 없애도 됨*/
					url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
					url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode("2629074", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("defaultYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("firstImageYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("addrinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스명=어플명*/
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				
				//파일 읽어들이기
		        URL realUrl = new URL(url);
		        HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Content-type", "application/json");
		        log.debug("Response code: " + conn.getResponseCode());
		        BufferedReader rd;
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		        }
		        
		        //파일 읽어서 한줄씩 String에 저장하기
		        String retString = "";
		        String line;
		        while ((line = rd.readLine()) != null) {
		           retString += line;
		        }
		        rd.close();
		        conn.disconnect();
		        //System.out.println(retString.toString());
		        
		        
		        //xml json으로 형변환
		        JSONObject json = XML.toJSONObject(retString);
		        String jsonStr = json.toString(4);
		        log.debug(jsonStr);
		        
		       
		        // JSONObject형식으로 지정
		        JSONObject jObject = new JSONObject(jsonStr);
		        
		        //response 안으로
		        JSONObject response = jObject.getJSONObject("response");
		        log.debug(response.toString(4));
		        
		        // body 안으로
		        JSONObject body = response.getJSONObject("body");
		        log.debug(body.toString(4));
		        
		        //items 안으로
		        JSONObject items = body.getJSONObject("items");
		        log.debug(items.toString(4));
		        
		        //item 선택
		        JSONObject item = items.getJSONObject("item");
		        log.debug(item.toString(4));
		      
		        // VO에 저장
		        Gson gson = new Gson();
		        CommonDetailVO vo = gson.fromJson(item.toString(), CommonDetailVO.class);
		        
		        //값 지정해서 콘텐츠 아이디 뽑아버리기
		        //log.debug(vo.contentid);
		        
		        return vo;
	}
	
	//TODO 식당 공통정보 조회
	@Override
	public CommonDetailVO getFoodCommonDetail() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
				String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon"; /*URL*/
				try {
					url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
					url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수 이거 필수값 아님 없애도 됨*/
					url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호 이거 필수값 아님 없애도 됨*/
					url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
					url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode("133324", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("defaultYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("firstImageYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("addrinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*서비스명=어플명*/
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				
				//파일 읽어들이기
		        URL realUrl = new URL(url);
		        HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setRequestProperty("Content-type", "application/json");
		        log.debug("Response code: " + conn.getResponseCode());
		        BufferedReader rd;
		        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
		            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        } else {
		            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		        }
		        
		        //파일 읽어서 한줄씩 String에 저장하기
		        String retString = "";
		        String line;
		        while ((line = rd.readLine()) != null) {
		           retString += line;
		        }
		        rd.close();
		        conn.disconnect();
		        //System.out.println(retString.toString());
		        
		        
		        //xml json으로 형변환
		        JSONObject json = XML.toJSONObject(retString);
		        String jsonStr = json.toString(4);
		        log.debug(jsonStr);
		        
		       
		        // JSONObject형식으로 지정
		        JSONObject jObject = new JSONObject(jsonStr);
		        
		        //response 안으로
		        JSONObject response = jObject.getJSONObject("response");
		        log.debug(response.toString(4));
		        
		        // body 안으로
		        JSONObject body = response.getJSONObject("body");
		        log.debug(body.toString(4));
		        
		        //items 안으로
		        JSONObject items = body.getJSONObject("items");
		        log.debug(items.toString(4));
		        
		        //item 선택
		        JSONObject item = items.getJSONObject("item");
		        log.debug(item.toString(4));
		      
		        // VO에 저장
		        Gson gson = new Gson();
		        CommonDetailVO vo = gson.fromJson(item.toString(), CommonDetailVO.class);
		        
		        //값 지정해서 콘텐츠 아이디 뽑아버리기
		        //log.debug(vo.contentid);
		        
		        return vo;
	}


	
	
	
	
}
