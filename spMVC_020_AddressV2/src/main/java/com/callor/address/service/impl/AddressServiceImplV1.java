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
public class AddressServiceImplV1 implements AddressService {

	/*
	 * Service interface에서 Dao를 상속받고 있는 상태에서 ServiceImpl 클래스에서 Dao를 생성자로 주입받는 경우
	 * 생성자에서 오류가 발생하는 경우가 있따 **circular reference : 무한 반복 주입 오류, 순환 참조 오류 이 오류가 발생하는
	 * 경우 생성자 주입 대신 setter 주입으로 변경하면 오류가 발생하지 않는다
	 */

	// 생성자 주입
	// private final AddressDao addrDao;
	//
	// public AddressServiceImplV1(AddressDao addrDao) {
	// this.addrDao = addrDao;
	// }

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
	
	// 한 페이지에 보여질 데이터 리스트 개수
	private static final long LIST_PER_PAGE = 10;
	
	// 화면 하단에 페이지 번호 출력 개수
	private static final long PAGE_NO_COUNT = 10;

	/*
	 * 조건에 맞는 데이터를 가져와서 PageNation을 그리기 위한 SearchPage 클래스의 데이터를 만들 것
	 */
	@Override
	public void searchAndPage(Model model, SearchPage searchPage) {
		
		// PageNation을 구현하기 위하여 전체 데이터 가져오기로 개수를 임시로 세팅
		searchPage.setOffset(0);
		searchPage.setLimit(addrDao.selectAll().size());
		

		// 검색어가 없이 요청이 될 경우 SearchPage 객체의 search 값이 null 되어 데이터가 검색되지 않는다
		// 때문에 SearchPage 객체의 search 변수 값을 "" 으로 세팅
		String search = searchPage.getSearch();
		search = search == null ? "" : search;
		searchPage.setSearch(search);

		
		// 1. 전체 데이터 개수가 몇 개 인지를 알아야 PageNation을 구현할 수 있다
		// 화면 하단의 페이지 번호를 자동으로 계산하기 위함이다
		
		// 검색어 조건에 맞는 모든 데이터를 일단 select
		List<AddressVO> addrList = addrDao.searchAndPage(searchPage);
		
		long totalCount = addrList.size();
		if(totalCount < 1) return;
		
		// 전체 데이터의 총 페이지 수
		// 전체 데이터 개수를 한 페이지에 보여질 데이터 개수로 나누기
		// 만약 전체 데이터가 37개, 한페이지에 10개일 경우 finalPageNo = 37/10 = 3
		long finalPageNo = totalCount / LIST_PER_PAGE;

		
		long currentPageNo = searchPage.getCurrentPageNo();
		
		// -----------------------------------------------------
		// 아래 두 종류의 코드는 같은 코드임
		
		// 3항 연산자 사용 [ ? = true일 때, : = false일 때]
		currentPageNo = currentPageNo > 1 ?
						 ( currentPageNo > finalPageNo 
						  ? finalPageNo : currentPageNo )
						: 1;
		
		// 일반적인 if 문을 사용 
		if(currentPageNo > finalPageNo) {
			currentPageNo = finalPageNo;
		}
		if(currentPageNo < 1) {
			currentPageNo = 1;
		}
		// -----------------------------------------------------
		
		// 선택된 페이지 번호에 따라 화면 하단 번호 리스트를 유동적으로 보여주기 위한 연산
		long startPageNo = (currentPageNo / PAGE_NO_COUNT) * PAGE_NO_COUNT; 
		
		startPageNo = startPageNo < 1 ? 1 : startPageNo;
		
		long endPageNo = startPageNo + PAGE_NO_COUNT;
		
		endPageNo = endPageNo > finalPageNo ? finalPageNo : endPageNo;
		
		searchPage.setStartPageNo(startPageNo);
		searchPage.setEndPageNo(endPageNo);
		searchPage.setLimit(LIST_PER_PAGE);
		searchPage.setOffset((currentPageNo - 1) * PAGE_NO_COUNT);
		searchPage.setFinalPageNo(finalPageNo);
		// searchPage.setListPerPage(LIST_PER_PAGE);
		
		// JSP로 보내기 위해서 모델에 담기
		model.addAttribute("PAGE", searchPage);
	}

}
