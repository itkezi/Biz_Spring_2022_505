package com.seasoning.app.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.seasoning.app.model.AroundVO;
import com.seasoning.app.model.LocationVO;
import com.seasoning.app.service.AroundService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AroundServiceImpl implements AroundService{

	
	
	//TODO 대구 
	@Override
	public List<AroundVO>  getDeaguAround() throws IOException{
		//공공데이터 키값하고 원하는 설정 연결하기
		String url ="http://api.visitkorea.or.kr/openapi/service/rest/KorService/locationBasedList"; /*URL*/
		try {
			url += ("?" + URLEncoder.encode("serviceKey","UTF-8") + "=gYKS7rrYVhnUEp3XTlvwEoDEMXL5foa3kM5B%2Fr0zeetiGTYyg4ZERj%2BiR6rPlEZji5q%2FeIlnRmkMTJT6XHn9Ow%3D%3D");
			url += ("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수 이거 필수값 아님 없애도 됨*/
			url += ("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호 이거 필수값 아님 없애도 됨*/
			url +=  ("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS (아이폰), AND (안드로이드), WIN (원도우폰), ETC*/
			url += ("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
			url += ("&" + URLEncoder.encode("mapX","UTF-8") + "=" + URLEncoder.encode("128.588231", "UTF-8")); /*좌표*/
			url += ("&" + URLEncoder.encode("mapY","UTF-8") + "=" + URLEncoder.encode("35.881253", "UTF-8")); /*좌표*/
			url += ("&" + URLEncoder.encode("radius","UTF-8") + "=" + URLEncoder.encode("3000", "UTF-8")); /*좌표*/
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
        List<AroundVO> list = gson.fromJson(item.toString(), new TypeToken<List<AroundVO>>(){}.getType());
        
        //값 지정해서 출력 성공!
        log.debug(list.get(2).title);
        
        
        return list;
	}

	@Override
	public List<AroundVO> getGangwon1Around() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AroundVO> getGangwon2Around() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AroundVO> getGimcheonAround() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AroundVO> getIncheonAround() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AroundVO> getJejuAround() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AroundVO> getJeonbukAround() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AroundVO> getPohangAround() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AroundVO> getSeongnamAround() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AroundVO> getSuwan_ssAround() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AroundVO> getSuwonAround() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AroundVO> getUlsanAround() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
