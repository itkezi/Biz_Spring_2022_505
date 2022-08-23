package com.itkezi.booksbooks.persistance;

import java.util.List;

import com.itkezi.booksbooks.model.BookVO;

public interface BookDao extends GenericDao<BookVO, Long>{
	
	public List<BookVO> findByUsername(String username);
	
	public void create_book_table();

}
