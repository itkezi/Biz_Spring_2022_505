package com.callor.ems.model;


import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EmsVO {

	private long e_seq;
	private String e_from_email;
	
	@NotEmpty(message="수신 이메일은 반드시 입력하세요")
	private String e_to_email;
	
	private String e_from_name;
	private String e_to_name;
	
	private String e_subject;
	private String e_content;
	private String e_send_Date;
	private String e_send_time;
}
