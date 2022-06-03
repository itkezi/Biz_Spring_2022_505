package com.callor.naver.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.naver.model.BookVO;

/*
 * 데이터 조회 method를 구현 할 때
 * PK(findById)를 기준으로 조회하는 method는 return type을 VO를 사용한다
 * PK가 아닌 칼럼을 기준으로 조회를 할 때는 데이터가 1개만 있을 것이라는 보장이 없기 때문에
 * return type을 반드시 List<VO>를 사용해야 한다
 */

public interface BookDao extends GenericDao<BookVO, String> {

	public List<BookVO> findByTitle(String title);

	public List<BookVO> findByAuthor(String author);

	public List<BookVO> findByPublisher(String publisher);

	public List<BookVO> findByPrice(int price);
	
//	@Select(" SELECT * FROM tbl_books ")
//	public List<BookVO> selectAll();
	
	@Select(" SELECT * FROM tbl_books "
			+ " WHERE isbn = #{isbn} ")
	public BookVO findByNum(String st_num);
	
	@Insert(SQL.BOOK.INSERT)
	public int insert(BookVO stVO);
	
	@Update(SQL.BOOK.UPDATE)
	public int update(BookVO stVO);
	
	@Delete("DELETE FROM tbl_books WHERE isbn = #{isbn} ")
	public int delete(String st_num);
}
