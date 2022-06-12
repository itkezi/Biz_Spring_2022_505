package com.seasoning.app.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.seasoning.app.model.LocationVO;
import com.seasoning.app.service.LocationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class locationServiceImpl implements LocationService{

	
	
	//TODO 서울 지역별 API
	@Override
	public List<LocationVO>  getSeoulLocation() throws IOException{
		//공공데이터 키값하고 원하는 설정 연결하기
		String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
		try {
			url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
			url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수 이거 필수값 아님 없애도 됨*/
			url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호 이거 필수값 아님 없애도 됨*/
			url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*지역코드, 시군구코드*/
			url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
        
        //item은 배열로 생성
        JSONArray item = items.getJSONArray("item");
        log.debug(item.toString(4));
      
        //json 배열을 List형으로 변형해서 VO에 저장
        Gson gson = new Gson();
        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
        
        //값 지정해서 출력 성공!
        log.debug(list.get(2).title);
        
        
        return list;
	}
	
	
	//TODO 부산 지역별 API
	@Override
	public List<LocationVO> getBusanLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
				String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
				try {
					url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
					url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
					url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
					url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
					url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("6", "UTF-8")); /*지역코드, 시군구코드*/
					url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
		        
		        //item은 배열로 생성
		        JSONArray item = items.getJSONArray("item");
		        log.debug(item.toString(4));
		      
		        //json 배열을 List형으로 변형해서 VO에 저장
		        Gson gson = new Gson();
		        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
		        
		        //값 지정해서 출력 성공!
		        log.debug(list.get(2).title);
		        
		        
		        return list;
	}
	
	//TODO 대구 지역별 API
	@Override
	public List<LocationVO> getDeaguLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
				String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
				try {
					url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
					url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
					url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
					url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
					url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("4", "UTF-8")); /*지역코드, 시군구코드*/
					url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
		        
		        //item은 배열로 생성
		        JSONArray item = items.getJSONArray("item");
		        log.debug(item.toString(4));
		      
		        //json 배열을 List형으로 변형해서 VO에 저장
		        Gson gson = new Gson();
		        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
		        
		        //값 지정해서 출력 성공!
		        log.debug(list.get(2).title);
		        
		        
		        return list;
	}

	//TODO 인천 지역별 API
	@Override
	public List<LocationVO> getIncheonLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
		String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
		try {
			url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
			url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
			url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
			url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("2", "UTF-8")); /*지역코드, 시군구코드*/
			url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
        
        //item은 배열로 생성
        JSONArray item = items.getJSONArray("item");
        log.debug(item.toString(4));
      
        //json 배열을 List형으로 변형해서 VO에 저장
        Gson gson = new Gson();
        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
        
        //값 지정해서 출력 성공!
        log.debug(list.get(2).title);
        
        
        return list;
	}
	
	//TODO 광주 지역별 API
	@Override
	public List<LocationVO> getGwangjuLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
		String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
		try {
			url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
			url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
			url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
			url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("5", "UTF-8")); /*지역코드, 시군구코드*/
			url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
        
        //item은 배열로 생성
        JSONArray item = items.getJSONArray("item");
        log.debug(item.toString(4));
      
        //json 배열을 List형으로 변형해서 VO에 저장
        Gson gson = new Gson();
        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
        
        //값 지정해서 출력 성공!
        log.debug(list.get(2).title);
        
        
        return list;
	}
	
	//TODO 대전 지역별 API
	@Override
	public List<LocationVO> getDeajeonLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
		String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
		try {
			url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
			url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
			url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
			url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /*지역코드, 시군구코드*/
			url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
        
        //item은 배열로 생성
        JSONArray item = items.getJSONArray("item");
        log.debug(item.toString(4));
      
        //json 배열을 List형으로 변형해서 VO에 저장
        Gson gson = new Gson();
        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
        
        //값 지정해서 출력 성공!
        log.debug(list.get(2).title);
        
        
        return list;
	}

	//TODO 울산 지역별 API
	@Override
	public List<LocationVO> getUlsanLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
		String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
		try {
			url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
			url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
			url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
			url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("7", "UTF-8")); /*지역코드, 시군구코드*/
			url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
        
        //item은 배열로 생성
        JSONArray item = items.getJSONArray("item");
        log.debug(item.toString(4));
      
        //json 배열을 List형으로 변형해서 VO에 저장
        Gson gson = new Gson();
        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
        
        //값 지정해서 출력 성공!
        log.debug(list.get(2).title);
        
        
        return list;
	}

	
	//TODO 세종 지역별 API
	@Override
	public List<LocationVO> getSejongLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
		String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
		try {
			url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
			url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
			url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
			url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("8", "UTF-8")); /*지역코드, 시군구코드*/
			url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
        
        //item은 배열로 생성
        JSONArray item = items.getJSONArray("item");
        log.debug(item.toString(4));
      
        //json 배열을 List형으로 변형해서 VO에 저장
        Gson gson = new Gson();
        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
        
        //값 지정해서 출력 성공!
        log.debug(list.get(2).title);
        
        
        return list;
	}
	
	//TODO 경기도 제역별 API
	@Override
	public List<LocationVO> getGGDLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
		String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
		try {
			url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
			url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
			url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
			url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("31", "UTF-8")); /*지역코드, 시군구코드*/
			url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
        
        //item은 배열로 생성
        JSONArray item = items.getJSONArray("item");
        log.debug(item.toString(4));
      
        //json 배열을 List형으로 변형해서 VO에 저장
        Gson gson = new Gson();
        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
        
        //값 지정해서 출력 성공!
        log.debug(list.get(2).title);
        
        
        return list;
	}

	//TODO 강원도 지역별 API
	@Override
	public List<LocationVO> getGWDLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
		String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
		try {
			url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
			url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
			url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
			url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("23", "UTF-8")); /*지역코드, 시군구코드*/
			url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
        
        //item은 배열로 생성
        JSONArray item = items.getJSONArray("item");
        log.debug(item.toString(4));
      
        //json 배열을 List형으로 변형해서 VO에 저장
        Gson gson = new Gson();
        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
        
        //값 지정해서 출력 성공!
        log.debug(list.get(2).title);
        
        
        return list;
	}

	//TODO 충청북도 지역별 API
	@Override
	public List<LocationVO> getCBDLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
		String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
		try {
			url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
			url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
			url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
			url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("33", "UTF-8")); /*지역코드, 시군구코드*/
			url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
        
        //item은 배열로 생성
        JSONArray item = items.getJSONArray("item");
        log.debug(item.toString(4));
      
        //json 배열을 List형으로 변형해서 VO에 저장
        Gson gson = new Gson();
        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
        
        //값 지정해서 출력 성공!
        log.debug(list.get(2).title);
        
        
        return list;
	}

	//TODO 충청남도 지역별 API
	@Override
	public List<LocationVO> getCNDLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
		String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
		try {
			url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
			url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
			url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
			url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("34", "UTF-8")); /*지역코드, 시군구코드*/
			url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
        
        //item은 배열로 생성
        JSONArray item = items.getJSONArray("item");
        log.debug(item.toString(4));
      
        //json 배열을 List형으로 변형해서 VO에 저장
        Gson gson = new Gson();
        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
        
        //값 지정해서 출력 성공!
        log.debug(list.get(2).title);
        
        
        return list;
	}

	//TODO 전라북도 지역 API
	@Override
	public List<LocationVO> getGRBDLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
				String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
				try {
					url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
					url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
					url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
					url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
					url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("35", "UTF-8")); /*지역코드, 시군구코드*/
					url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
		        
		        //item은 배열로 생성
		        JSONArray item = items.getJSONArray("item");
		        log.debug(item.toString(4));
		      
		        //json 배열을 List형으로 변형해서 VO에 저장
		        Gson gson = new Gson();
		        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
		        
		        //값 지정해서 출력 성공!
		        log.debug(list.get(2).title);
		        
		        
		        return list;
	}

	//TODO 전라남도 지역별 API
	@Override
	public List<LocationVO> getGRNDLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
				String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
				try {
					url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
					url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
					url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
					url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
					url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("36", "UTF-8")); /*지역코드, 시군구코드*/
					url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
		        
		        //item은 배열로 생성
		        JSONArray item = items.getJSONArray("item");
		        log.debug(item.toString(4));
		      
		        //json 배열을 List형으로 변형해서 VO에 저장
		        Gson gson = new Gson();
		        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
		        
		        //값 지정해서 출력 성공!
		        log.debug(list.get(2).title);
		        
		        
		        return list;
	}

	//TODO 경상북도 지역별 API
	@Override
	public List<LocationVO> getGSBDLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
				String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
				try {
					url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
					url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
					url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
					url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
					url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("37", "UTF-8")); /*지역코드, 시군구코드*/
					url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
		        
		        //item은 배열로 생성
		        JSONArray item = items.getJSONArray("item");
		        log.debug(item.toString(4));
		      
		        //json 배열을 List형으로 변형해서 VO에 저장
		        Gson gson = new Gson();
		        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
		        
		        //값 지정해서 출력 성공!
		        log.debug(list.get(2).title);
		        
		        
		        return list;
	}
	
	//TODO 경상남도 지역별 API
	@Override
	public List<LocationVO> getGSNDLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
				String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
				try {
					url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
					url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
					url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
					url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
					url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("38", "UTF-8")); /*지역코드, 시군구코드*/
					url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
		        
		        //item은 배열로 생성
		        JSONArray item = items.getJSONArray("item");
		        log.debug(item.toString(4));
		      
		        //json 배열을 List형으로 변형해서 VO에 저장
		        Gson gson = new Gson();
		        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
		        
		        //값 지정해서 출력 성공!
		        log.debug(list.get(2).title);
		        
		        
		        return list;
	}
	
	
	//TODO 제주 지역별 APi
	@Override
	public List<LocationVO> getJejuLocation() throws IOException {
		//공공데이터 키값하고 원하는 설정 연결하기
				String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"; /*URL*/
				try {
					url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
					url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
					url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
					url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
					url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
					url += ("&" + URLEncoder.encode("areaCode","UTF-8") + "=" + URLEncoder.encode("39", "UTF-8")); /*지역코드, 시군구코드*/
					url += ("&" + URLEncoder.encode("listYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드*/
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
		        
		        //item은 배열로 생성
		        JSONArray item = items.getJSONArray("item");
		        log.debug(item.toString(4));
		      
		        //json 배열을 List형으로 변형해서 VO에 저장
		        Gson gson = new Gson();
		        List<LocationVO> list = gson.fromJson(item.toString(), new TypeToken<List<LocationVO>>(){}.getType());
		        
		        //값 지정해서 출력 성공!
		        log.debug(list.get(2).title);
		        
		        
		        return list;
	}

}
