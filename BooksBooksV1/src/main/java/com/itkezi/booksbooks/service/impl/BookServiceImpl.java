package com.itkezi.booksbooks.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itkezi.booksbooks.model.BookVO;
import com.itkezi.booksbooks.persistance.BookDao;
import com.itkezi.booksbooks.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private final BookDao bookDao;
	
	
	
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void create_book_table() {
	}

	@Override
	public List<BookVO> selectAll() {
		return bookDao.selectAll();
	}

	@Override
	public List<BookVO> findByUsername(String username) {
		return bookDao.findByUsername(username);
	}


	@Override
	public BookVO findById(Long id) {
		return bookDao.findById(id);
	}

	@Override
	public int insert(BookVO vo) {
		return bookDao.insert(vo);
	}

	@Override
	public int update(BookVO vo) {
		return bookDao.update(vo);
	}

	@Override
	public int delete(Long id) {
		return bookDao.delete(id);
	}

}
