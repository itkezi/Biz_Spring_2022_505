package com.seasoning.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseBallScheduleVO {
	private String st_pk;
	private String bb_st_name;	// 경기장 이름
	private String st_date;		// 경기 날짜
	private String st_match;	// 매치업
}
