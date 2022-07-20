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

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final AddressService addressService;
	
	public HomeController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, 
			@RequestParam(name="pageno", required=false, defaultValue="0") int pageno,
			SearchPage searchPage) {

		
		// List<AddressVO> addr = addressService.selectAll();
		
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
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String insert() {
		return "insert";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public String insert (AddressVO addr) {
		addressService.insert(addr);
		
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
		
		return "insert";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(AddressVO addressVO) {
		
		addressService.update(addressVO);
		
		String retStr = String.format("redirect:/detail/?seq=" + addressVO.getA_seq());
		
		return retStr;
	}
	
	/*
	 * Controller의 method에서 문자열을 return하면
	 * tiles/layout.xml 파일에서 해당하는 문자열로 선언된 definition을 찾는다
	 * 해당하는 문자열로 선언된 definition 있으면 layout.xml 설정된 대로
	 * tiles가 작동되어 layout 만들고 rendering 하여 응답을 한다
	 * 
	 * 만약 layout.xml에 해당하는 definition이 없으면
	 * InternalRexourceViewResolver가 작동되어 /views/문자열.jsp 파일을 찾아서 rendering 하여 응답한다
	 */
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String about() {
		return "about";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam(name = "seq", required= false, defaultValue="0") long a_seq, Model model) {
		log.debug("삭제 할 a_seq : {}", a_seq);
		
		addressService.delete(a_seq);
		
		return "redirect:/";
	}
	
}
