package com.seasoning.app.service;

import java.io.IOException;

import com.seasoning.app.model.CommonDetailVO;
import com.seasoning.app.model.FoodDetailVO;
import com.seasoning.app.model.LodgmentDetailVO;
import com.seasoning.app.model.TourDetailVO;

public interface DetailService {
	
	public TourDetailVO getTourDetail() throws IOException;
	public FoodDetailVO getFoodDetail() throws IOException;
	public LodgmentDetailVO getLodgmentDetail() throws IOException;
	
	public CommonDetailVO getTourCommonDetail() throws IOException;
	public CommonDetailVO getFoodCommonDetail() throws IOException;
	public CommonDetailVO getLodgmentCommonDetail() throws IOException;

}
