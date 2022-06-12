package com.seasoning.app.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seasoning.app.model.LocationVO;
import com.seasoning.app.service.LocationService;

@RequestMapping(value = "/location")
@Controller
public class LocationController {

	private final LocationService locationService;

	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}
	
	//TODO 서울
	@RequestMapping(value="/seoul", method=RequestMethod.GET)
	public String getSeoulLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getSeoulLocation();
		
		model.addAttribute("SEOUL",locationList);
		
		return "/location/seoul";
		
	}

	//TODO 인천
	@RequestMapping(value="/incheon", method=RequestMethod.GET)
	public String getIncheonLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getIncheonLocation();
		
		model.addAttribute("INCHEON",locationList);
		
		return "/location/incheon";
		
	}
	
	//TODO 대전
	@RequestMapping(value="/deajeon", method=RequestMethod.GET)
	public String getDeajeonLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getDeajeonLocation();
		
		model.addAttribute("DEAJEON",locationList);
		
		return "/location/deajeon";
		
	}
	
	//TODO 대구
	@RequestMapping(value="/deagu", method=RequestMethod.GET)
	public String getDeaguLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getDeaguLocation();
		
		model.addAttribute("DEAGU",locationList);
		
		return "/location/deagu";
		
	}
	
	//TODO 광주
	@RequestMapping(value="/gwangju", method=RequestMethod.GET)
	public String getGwangjuLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getGwangjuLocation();
		
		model.addAttribute("GWANGJU",locationList);
		
		return "/location/gwangju";
		
	}
	
	//TODO 부산
	@RequestMapping(value="/busan", method=RequestMethod.GET)
	public String getBusanLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getBusanLocation();
		
		model.addAttribute("BUSAN",locationList);
		
		return "/location/busan";
		
	}
	
	//TODO 울산
	@RequestMapping(value="/ulsan", method=RequestMethod.GET)
	public String getUlsanLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getUlsanLocation();
		
		model.addAttribute("ULSAN",locationList);
		
		return "/location/ulsan";
		
	}
	
	//TODO 세종
	@RequestMapping(value="/sejong", method=RequestMethod.GET)
	public String getSejongLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getSejongLocation();
		
		model.addAttribute("SEJONG",locationList);
		
		return "/location/sejong";
		
	}
	
	//TODO 경기도
	@RequestMapping(value="/ggd", method=RequestMethod.GET)
	public String getGGDLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getGGDLocation();
		
		model.addAttribute("GGD",locationList);
		
		return "/location/ggd";
		
	}
	
	//TODO 강원도
	@RequestMapping(value="/gwd", method=RequestMethod.GET)
	public String getGWDLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getGWDLocation();
		
		model.addAttribute("GWD",locationList);
		
		return "/location/gwd";
		
	}
	
	//TODO 충청북도
	@RequestMapping(value="/cbd", method=RequestMethod.GET)
	public String getCBDLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getCBDLocation();
		
		model.addAttribute("CBD",locationList);
		
		return "/location/cbd";
		
	}
	
	//TODO 충청남도
	@RequestMapping(value="/cnd", method=RequestMethod.GET)
	public String getCNDLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getCNDLocation();
		
		model.addAttribute("CND",locationList);
		
		return "/location/cnd";
		
	}
	
	//TODO 전라북도
	@RequestMapping(value="/grbd", method=RequestMethod.GET)
	public String getGRBDLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getGRBDLocation();
		
		model.addAttribute("GRBD",locationList);
		
		return "/location/grbd";
		
	}
	
	//TODO 전라남도
	@RequestMapping(value="/grnd", method=RequestMethod.GET)
	public String getGRNDLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getGRNDLocation();
		
		model.addAttribute("GRND",locationList);
		
		return "/location/grnd";
		
	}
	
	//TODO 경상북도
	@RequestMapping(value="/gsbd", method=RequestMethod.GET)
	public String getGSBDLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getGSBDLocation();
		
		model.addAttribute("GSBD",locationList);
		
		return "/location/gsbd";
		
	}
	
	//TODO 경상남도
	@RequestMapping(value="/gsnd", method=RequestMethod.GET)
	public String getGSNDLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getGSNDLocation();
		
		model.addAttribute("GSND",locationList);
		
		return "/location/gsnd";
		
	}
	
	//TODO 제주
	@RequestMapping(value="/jeju", method=RequestMethod.GET)
	public String getJejuLocation(Model model) throws IOException{
		
		List<LocationVO> locationList = locationService.getJejuLocation();
		
		model.addAttribute("JEJU",locationList);
		
		return "/location/jeju";
		
	}	
}
