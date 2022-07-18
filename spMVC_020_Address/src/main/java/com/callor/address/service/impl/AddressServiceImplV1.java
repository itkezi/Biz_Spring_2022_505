package com.callor.address.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.address.config.QualifyConfig;
import com.callor.address.model.AddressVO;
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
	
	

}
