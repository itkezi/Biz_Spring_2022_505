package com.callor.naver.persistance;

public class SQL {
	
	public static class BOOK {
		
		public static final String INSERT = 
				" INSERT INTO tbl_books ( "
				+" isbn,"
				+" title,"
				+" author,"
				+" publisher,"		
				+" pubdate,"
				+" price"
				+" ) VALUES ( "
				+" 	#{isbn},"
				+" 	#{title},"
				+" 	#{author},"
				+" 	#{publisher},"		
				+" 	#{pubdate},"
				+" 	#{price}";
					

		public static final String UPDATE ="" 
				+" UPDATE SET tbl_books"
				+" title =	#{title},"
				+" author = #{author},"
				+" publisher = #{publisher},"		
				+" pubdate = #{pubdate},"
				+" price = #{price}"
				+" WHERE isbn = #{isbn} ";
	}
}

