package com.callor.school.dao;

public class SQL {

	public static class STUDENT {
		// 반드시 final이어야 함
		public static final String INSERT
		= " INSERT INTO tbl_student( " 
						+" st_num,"
						+" st_name,"
						+" st_dept,"
						+" st_grade,"
						+" st_tel,"
						+" st_addr,"
						+" ) VALUES ( "
						+" #{st_num},"
						+" #{st_name},"
						+" #{st_dept},"
						+" #{st_grade},"
						+" #{st_tel},"
						+" #{st_addr})";
		
		// 반드시 final이어야 함
		public static final String UPDATE = ""
		+ " UPDATE SET tbl_student "
//		+ " st_num		 = #{st_num},"   WHERE 절에서 사용하기 때문에 지워도 됨
		+ " st_name	 	 = #{st_name},"
		+ " st_dept	 	 = #{st_dept},"
		+ " st_grade 	 = #{st_grade},"
		+ " st_tel	 	 = #{st_tel},"
		+ " st_addr		 = #{st_addr}"
		+ " WHERE st_num = #{st_num}";

	}
}
