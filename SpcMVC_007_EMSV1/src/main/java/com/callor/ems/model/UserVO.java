package com.callor.ems.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

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
public class UserVO {
	
	@Size(min = 5, max = 12, 
			message="5 ~ 12 글자로 만드슈")
	private String username;
	
	//	@Pattern(regexp = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$", 
	//			message="영문, 숫자, 특문 포함 8 ~ 15글자")
	private String password;
	
	@Email(message="이메일 정확히 입력")
	private String email;
	private String name;
	private String role;
	
	private String key;
	private String key_ok;

}
