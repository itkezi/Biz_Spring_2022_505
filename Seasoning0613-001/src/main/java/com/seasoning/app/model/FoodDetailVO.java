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
public class FoodDetailVO {
	public String contentid;
	public String contenttypeid;
	public String discountinfofood;
	public String firstmenu;
	public String infocenterfood;
	public String opentimefood;
	public String parkingfood;
	public String reservationfood;
	public String restdatefood;
	public String seat;
	public String treatmenu;
	


}
