package com.callor.images.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.images.config.QualifierConfig;
import com.callor.images.model.StartMenuDTO;
import com.callor.images.model.WorkOutDTO;
import com.callor.images.persistance.SelfitDao;

@Service(QualifierConfig.SERVICE.SELFIT_V2)
public class SelfitServiceImplV2 extends SelfitServiceImplV1{
	
	public SelfitServiceImplV2(SelfitDao selfitDao) {
		super(selfitDao);
	}

	@Override
	public void StartPage(Model model) {
		
		List<StartMenuDTO> beginMenus = selfitDao.selectByscNum("01");
		List<StartMenuDTO> middleMenus = selfitDao.selectByscNum("02");
		List<StartMenuDTO> advMenus = selfitDao.selectByscNum("03");
		
		
		
		// 각각 메뉴를 개별적으로 model에 담기
		model.addAttribute("BEGIN_MENU", beginMenus);
		model.addAttribute("MIDDLE_MENU", middleMenus);
		model.addAttribute("ADV_MENU", advMenus);
		
		
	}

	@Override
	public void getDaySetList(Model model, String sc_num) {

			super.getDaySetList(model, sc_num);
			
			List<StartMenuDTO> dayList = (List<StartMenuDTO>) model.getAttribute("DAYS");
			
			String sc_id = dayList.get(0).getSc_id();
			
			// sc_id를 매개변수로 전달하여 view_workout의 데이터를 가져오기
			List<WorkOutDTO> workList = selfitDao.selectWorkOut(sc_id);
			
			model.addAttribute("WORKS", workList);
		
	}
	
	@Override
	public void getDaySetList(Model model, String sc_num, String sc_id) {
		super.getDaySetList(model, sc_num);
		
		List<WorkOutDTO> workList = selfitDao.selectWorkOut(sc_id);
		model.addAttribute("WORKS", workList);
	}
	
	@Override
	public WorkOutDTO getDayHealth(String sc_id, String listid) {
		return selfitDao.selectDayHealth(sc_id,listid);
	
	}

}
