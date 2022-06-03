package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.service.BookService;


/*
 * ("bookServiceV1")
 * BookService interface를 상속받은 클래스가 다수 있을 때 Controller에서 어떤 클래스를 지금 연결하여 사용할 것인다의 문제가 발생한다
 * 
 * 그럴 때 @Service Annotation 이름(식별자)을 부착하여 두고 클래스 중에서 필요한 부분을 선택할 수 있도록 하기 위하여 부착하는 것
 */
@Service(QualifierConfig.SERVICE.BOOKS_V1)
public class BookServiceImplV1 implements BookService{

	@Override
	public List<BookVO> findByTitle(String title) {
		return null;
	}

	@Override
	public List<BookVO> findByAuthor(String author) {
		return null;
	}

	@Override
	public List<BookVO> findByPublisher(String publisher) {
		return null;
	}

	@Override
	public List<BookVO> findByPrice(int price) {
		return null;
	}

	@Override
	public List<BookVO> selectAll() {
		return null;
	}

	@Override
	public BookVO findById(String id) {
		return null;
	}

	@Override
	public int insert(BookVO vo) {
 		return 0;
	}

	@Override
	public int update(BookVO vo) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

}
