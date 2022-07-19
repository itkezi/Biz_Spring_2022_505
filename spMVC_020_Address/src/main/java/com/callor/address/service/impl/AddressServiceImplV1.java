package com.callor.address.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.address.config.QualifyConfig;
import com.callor.address.model.AddressVO;
import com.callor.address.model.SearchPage;
import com.callor.address.persistance.AddressDao;
import com.callor.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifyConfig.SERVICE.ADDR_V1)
public class AddressServiceImplV1 implements AddressService{
	
	
	/*
	 * Service interface에서 Dao를 상속받고 있는 상태에서
	 * ServiceImpl 클래스에서 Dao를 생성자로 주입받는 경우
	 * 생성자에서 오류가 발생하는 경우가 있따 **circular reference : 무한 반복 주입 오류, 순환 참조 오류
	 * 이 오류가 발생하는 경우 생성자 주입 대신 setter 주입으로 변경하면 오류가 발생하지 않는다
	 */

	// 생성자 주입
	//	private final AddressDao addrDao;
	//
	//	public AddressServiceImplV1(AddressDao addrDao) {
	//		this.addrDao = addrDao;
	//	}
	
	// setter 주입 (final 사용 금지)
	@Autowired
	private AddressDao addrDao;
	
	public AddressServiceImplV1() {
	}
	
	// 프로젝트가 시작될 때 table을 자동으로 생성하기 위한 자동실행
	@Autowired
	public void create_table() {
		addrDao.create_addr_table();
		log.info("tbl_address 확인 완료");
	}
	
	@Override
	public List<AddressVO> selectAll() {
		
		List<AddressVO> addr = addrDao.selectAll();
		
		return addr;
	}

	@Override
	public AddressVO findById(Long a_seq) {
		
		AddressVO addr = addrDao.findById(a_seq);
		
		return addr;
	}

	@Override
	public int insert(AddressVO vo) {
		log.info("서비스에서 받은 데이터 : {} ", vo.toString());
		addrDao.insert(vo);
		return 0;
	}

	@Override
	public int update(AddressVO vo) {
		addrDao.update(vo);
		return 0;
	}

	@Override
	public int delete(Long a_seq) {
		addrDao.delete(a_seq);
		return 0;
	}

	/*
	 * 이 method에서 dao의 create_addr_table() method를 호출하여  
	 */
	@Override
	public void create_addr_table() {
	}

	   @Override
	   public List<AddressVO> searchAndPage(SearchPage searchPage) {
	      return addrDao.searchAndPage(searchPage);
	   }

	/*
	 * 조건에 맞는 데이터를 가져와서 pagenation을 그리기 위한 SearchPage 클래스의 데이터를 만들 것
	 */
	@Override
	public void searchAndPage(Model model, SearchPage searchPage) {
		
		searchPage.setLimit(addrDao.selectAll().size());
		searchPage.setOffset(0);
		
		// 검색어 조건에 맞는 모든 데이터 가져오기
		List<AddressVO> addList = addrDao.searchAndPage(searchPage);
		
		long totalCount = addList.size();
		
		// 조건에 맞는 데이터가 없으면 중단하기
		if(totalCount < 1 ) return;
		
		// 보여질 데이터 리스트 개수
		searchPage.setListPerPage(5);
		
		// 하단의 페이지 번호 개수
		searchPage.setPageNoCount(10);
		
		// 조건에 맞는 전체 데이터 개수
		searchPage.setTotalCount(totalCount);
		
		// (전체데이터개수 -1) / 보여질개수
		long finalPageNo = (totalCount -1) / searchPage.getListPerPage();
		
		searchPage.setFinalPageNo(finalPageNo);
		
		if(searchPage.getCurrentPageNo() > finalPageNo) {
			searchPage.setCurrentPageNo(finalPageNo);
		}
		
		if(searchPage.getCurrentPageNo() < 1) {
			searchPage.setCurrentPageNo(1);
		}
		
		long startPageNo = ((searchPage.getCurrentPageNo()-1) / searchPage.getPageNoCount()) * searchPage.getPageNoCount() +1;
		
		long endPageNo = startPageNo + searchPage.getPageNoCount()-1;
		
		searchPage.setStartPageNo(startPageNo);
		searchPage.setEndPageNo(endPageNo);
		searchPage.setLimit(searchPage.getPageNoCount());
		searchPage.setOffset(searchPage.getCurrentPageNo() * searchPage.getPageNoCount());
		
		model.addAttribute("PAGE", searchPage);
		
	}
	
	

}
