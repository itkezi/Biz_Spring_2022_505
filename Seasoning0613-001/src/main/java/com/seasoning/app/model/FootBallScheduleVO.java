package com.seasoning.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FootBallScheduleVO {
	private String fb_st_pk;
	private String fb_st_name;	// 경기장 이름
	private String fb_st_date;	// 경기 날짜
	private String fb_st_time;	// 경기 시간
	private String fb_st_match;	// 매치업
}
