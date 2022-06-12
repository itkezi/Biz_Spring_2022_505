package com.seasoning.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
<<<<<<<< HEAD:API-/Seasoning_2022/src/main/java/com/seasoning/app/model/MapVO.java
public class MapVO {
	private String st_pk;
	private String bb_st_name;
	private String bb_st_x;
	private String bb_st_y;
========
public class MemberVO {
	
	private String username;
	private String password;
	private String name;
	private String nickname;
	private String email;
	private String tel;
	private String role;

>>>>>>>> c68384cd9ef4a9db6a4247658c23867f593e25df:SpMVC_004_NaverV4/src/main/java/com/callor/naver/model/MemberVO.java
}
