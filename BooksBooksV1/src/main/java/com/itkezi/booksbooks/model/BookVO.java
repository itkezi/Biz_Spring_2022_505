package com.itkezi.booksbooks.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BookVO {

	private Long seq;
	private String b_username;
	private String b_image;
	private String b_title;
	private String b_author;
	private String b_publisher;
	private String b_description;
	private String b_link;
	private String b_letter;
	private String b_price;
	private String b_page;
	private boolean b_comp;
	
	

	
}
