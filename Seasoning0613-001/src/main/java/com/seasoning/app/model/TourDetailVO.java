package com.seasoning.app.model;

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
public class TourDetailVO {
	public String contentid;
	public String contenttypeid;
	public String accomcount;
	public String chkbabycarriage;
	public String chkcreditcard;
	public String chkpet;
	public String expagerange;
	public String expguide;
	public String heritage1;
	public String heritage2;
	public String heritage3;
	public String infocenter;
	public String opendate;
	public String parking;
	public String restdate;
	public String useseason;
	public String usetime;

}
