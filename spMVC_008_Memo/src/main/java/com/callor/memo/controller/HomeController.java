package com.callor.memo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final MemoService memoService;
	
	private final MemoDao memoDao;
	
	public HomeController(MemoDao memoDao,  MemoService memoService) {
		this.memoDao = memoDao;
		this.memoService = memoService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<MemoVO> memos = memoDao.selectAll();
		model.addAttribute("MEMOS", memos);
		
		return "list";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return null;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(MemoVO memoVO,  @RequestParam("file") MultipartFile file) {
		
		int ret = memoService.insert(memoVO, file);
		
		log.info(memoVO.toString());
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/detail/{m_seq}", method = RequestMethod.GET)
	public String detail(@PathVariable("m_seq") Long m_seq, Model model) {
		
		MemoVO memoVO = memoService.findById(m_seq);
		
		model.addAttribute("MEMO" , memoVO);
		
		return "detail";
	}
	
	@RequestMapping(value = "/update/{m_seq}", method = RequestMethod.GET)
	public String update(MemoVO memoVO) {
		
		memoService.update(memoVO);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/insert/{m_seq}", method = RequestMethod.GET)
	public String delete(MemoVO memoVO) {
		
		int ret = memoService.delete(memoVO.getM_seq());
		
		return "redirect:/";
	}	
	
	
}
