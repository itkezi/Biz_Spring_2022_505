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
public class LodgmentDetailVO {
	
	public String contentid;
	public String contenttypeid;
	public String accomcountlodging;
	public String checkintime;
	public String checkouttime;
	public String chkcooking;
	public String foodplace;
	public String infocenterlodging;
	public String parkinglodging;
	public String pickup;
	public String roomcount;
	public String reservationlodging;
	public String reservationurl;
	public String roomtype;
	public String scalelodging;
	public String refundregulation;


}
