package com.itkezi.letterbunker.persistance;

import java.util.List;

import com.itkezi.letterbunker.model.BookVO;

public interface BookDao extends GenericDao<BookVO, String>{

	public List<BookVO> findByTitle(String title);
	public List<BookVO> findByAuthor(String author);
	public List<BookVO> findByPublisher(String publisher);
	public List<BookVO> findByPrice(int price);
	
	public void create_book_table() ;
	
	
}
