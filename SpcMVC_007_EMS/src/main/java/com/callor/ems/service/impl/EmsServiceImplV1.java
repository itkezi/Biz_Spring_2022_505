package com.callor.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.ems.model.EmsVO;
import com.callor.ems.persistance.EmsDao;
import com.callor.ems.service.EmsService;

@Service
public class EmsServiceImplV1 implements EmsService{
	
	private final EmsDao emsDao;
	
	public EmsServiceImplV1(EmsDao emsDao) {
		this.emsDao = emsDao;
	}

	@Override
	@Autowired
	public void create_ems_table() {
		emsDao.create_ems_table();
		
	}

	@Override
	public List<EmsVO> selectAll() {
		return null;
	}

	@Override
	public EmsVO findById(Long id) {
		return null;
	}

	@Override
	public int insert(EmsVO vo) {
		return 0;
	}

	@Override
	public int update(EmsVO vo) {
		return 0;
	}

	@Override
	public int delete(Long id) {
		return 0;
	}

}
