package com.callor.memo.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemoServiceImplV1 implements MemoService{

	private final MemoDao memoDao;
	
	private final String upLoadFolder;
	
	public MemoServiceImplV1(MemoDao memoDao, String upLoadFolder) {
		this.memoDao = memoDao;
		this.upLoadFolder = upLoadFolder;
	}
	
	@Override
	public void create_memo_table() {
		memoDao.create_memo_table();
		log.debug("tbl_memo 생성 완료");
		
	}

	@Override
	public List<MemoVO> selectAll() {
		List<MemoVO> memos = memoDao.selectAll();
		log.info(memos.toString());
		return memos;
	}

	@Override
	public MemoVO findById(Long id) {
		return memoDao.findById(id);
	}

	@Override
	public int insert(MemoVO vo, MultipartFile file) {	
		
		MemoVO mVO = null;
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		try {
			String fileName = fileUp(file);
		
			mVO = MemoVO.builder()
					.m_author(vo.getM_author())
					.m_date(dayFormat.format(date))
					.m_time(timeFormat.format(date))
					.m_memo(vo.getM_memo())
					.m_image(fileName)
					.build();
		
		} catch (Exception e) {
			log.info("업로드 실패");
		}
		
		int ret = memoDao.insert(mVO);
		
		return ret;
	}

	@Override
	public int update(MemoVO vo, MultipartFile file) {

		memoDao.update(vo);
		
		return 0;
	}

	@Override
	public int delete(Long id) {
		
		memoDao.delete(id);
		
		return 0;
	}

	@Override
	public int insert(MemoVO vo) {
		return 0;
	}

	@Override
	public int update(MemoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {
		
		if(file == null) {
			return null;
		}
		File dir = new File(upLoadFolder);
		if( !dir.exists()) {
			dir.mkdirs();
		}
		
		String fileName = file.getOriginalFilename();
		
		String strUUID = UUID.randomUUID().toString();
		
		fileName = String.format("%s-%s", strUUID, fileName);
		log.debug("변경된 파일이름 {}", fileName);
		
		File upLoadFile = new File(upLoadFolder, fileName);
		
		file.transferTo(upLoadFile);
		
		return fileName;
	}
	


}
