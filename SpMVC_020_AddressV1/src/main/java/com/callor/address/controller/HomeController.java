package com.callor.address.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.address.model.AddressVO;
import com.callor.address.model.SearchPage;
import com.callor.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final AddressService addressService;
	
	public HomeController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, @RequestParam(name="pageno", required=false, defaultValue="0") int pageno) {
		
		// List<AddressVO> addr = addressService.selectAll();
		
		SearchPage searchPage = SearchPage.builder()
				.a_name("")
				.limit(10)
				.offset(pageno * 10)
				.build();
		
		searchPage.setCurrentPageNo(pageno);
		
		// 페이지 계산
		addressService.searchAndPage(model, searchPage);
		
		// 데이터 가져오기
		List<AddressVO> addr = addressService.searchAndPage(searchPage);
		model.addAttribute("ADDRS",addr);
		
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(AddressVO addressVO) {
		
		addressService.insert(addressVO);
		
//		log.debug(addressVO.toString());
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(@RequestParam(name = "seq", required= false, defaultValue="0") long a_seq, Model model) {
		log.debug("상세보기 할 a_seq : {}", a_seq);
		
		AddressVO addrVO = addressService.findById(a_seq);
		model.addAttribute("ADDR",addrVO);
		
		return "detail";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(@RequestParam(name = "seq", required= false, defaultValue="0") long a_seq, Model model) {
		log.debug("업데이트 할 a_seq : {}", a_seq);
		
		AddressVO addrVO = addressService.findById(a_seq);
		
		model.addAttribute("ADDR",addrVO);
		
		return "home";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(AddressVO addressVO) {
		
		addressService.update(addressVO);
		
		String retStr = String.format("redirect:/detail/?seq=" + addressVO.getA_seq());
		
		return retStr;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam(name = "seq", required= false, defaultValue="0") long a_seq, Model model) {
		log.debug("삭제 할 a_seq : {}", a_seq);
		
		addressService.delete(a_seq);
		
		return "redirect:/";
	}
	
}
