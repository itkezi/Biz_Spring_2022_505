package com.callor.naver.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.callor.naver.model.BookVO;
import com.callor.naver.model.BuyBooksVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.persistance.BookDao;
import com.callor.naver.persistance.BuyBooksDao;
import com.callor.naver.service.BuyBooksService;

@Service
public class BuybooksServiceImplV1 implements BuyBooksService{
	
	@Autowired
	protected BookDao bookDao;
	
	@Autowired
	protected BuyBooksDao buyDao;

	@Override
	public List<BuyBooksVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BuyBooksVO findByisbnAndUserName(String isbn, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyBooksVO> findByisbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyBooksVO> findByUserName(String username) {
		
		
		return buyDao.findByUserName(username);
	}

	// 사용 X
	@Override
	public int insert(BuyBooksVO vo) {
		return 0;
	}

	/*
	 * userVO와 bookVO에 담긴 데이터를 기준으로
	 * tbl_books 데이터와 tbl_buybooks 데이터를 추가하기
	 * 만약 tbl_books table에 이미 같은 ISBN이 있으면 update 수행 
	 */
	@Transactional
	@Override
	public int insert(UserVO userVO, BookVO bookVO) {
		
		// isbn에 해당하는 도서가 있냐
		BookVO resultBook = bookDao.findById(bookVO.getIsbn());
		
		if (resultBook == null) {
			// 없으면 insert
			bookDao.insert(bookVO);
		} else {
			// 있으면 update
			bookDao.update(bookVO);
		}
		
		// 구입한 도서 정보를 tbl_buybokks에 추가하기
		
		// 1. 구입할 일자를 자동으로 생성하기
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		BuyBooksVO buyBooksVO = BuyBooksVO.builder()
											.b_date(dateFormat.format(date))
											.b_isbn(bookVO.getIsbn())
											.b_username(userVO.getUsername())
											.build();
		
		buyDao.insert(buyBooksVO);
		
		return 0;
	}

}
