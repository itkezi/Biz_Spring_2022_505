package com.callor.memo.service;

import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;

public interface MemoService extends MemoDao{

	public int insert(MemoVO vo, MultipartFile file);

	int update(MemoVO vo, MultipartFile file);

	String fileUp(MultipartFile file) throws Exception;

}
