package com.seasoning.app.service;

import java.io.IOException;
import java.util.List;

import com.seasoning.app.model.FoodVO;
import com.seasoning.app.model.LodgmentVO;
import com.seasoning.app.model.TourListVO;

public interface DetailService {
	
	public TourListVO getTourDetail() throws IOException;
	public FoodVO getFoodDetail() throws IOException;
	public LodgmentVO getLodgmentDetail() throws IOException;

}
