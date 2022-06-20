package com.seasoning.app.service;

import java.io.IOException;
import java.util.List;

import com.seasoning.app.model.LocationVO;

public interface FoodLocationService {
	
	public List<LocationVO> getSeoul_FoodLocation() throws IOException;
	public List<LocationVO> getBusan_FoodLocation() throws IOException;
	public List<LocationVO> getDeagu_FoodLocation() throws IOException;
	public List<LocationVO> getIncheon_FoodLocation() throws IOException;
	public List<LocationVO> getGwangju_FoodLocation() throws IOException;
	public List<LocationVO> getDeajeon_FoodLocation() throws IOException;
	public List<LocationVO> getUlsan_FoodLocation() throws IOException;
	public List<LocationVO> getSejong_FoodLocation() throws IOException;
	public List<LocationVO> getGGD_FoodLocation() throws IOException;
	public List<LocationVO> getGWD_FoodLocation() throws IOException;
	public List<LocationVO> getCBD_FoodLocation() throws IOException;
	public List<LocationVO> getCND_FoodLocation() throws IOException;
	public List<LocationVO> getGRBD_FoodLocation() throws IOException;
	public List<LocationVO> getGRND_FoodLocation() throws IOException;
	public List<LocationVO> getGSBD_FoodLocation() throws IOException;
	public List<LocationVO> getGSND_FoodLocation() throws IOException;
	public List<LocationVO> getJeju_FoodLocation() throws IOException;
	
	public String getContentId() throws IOException;
	

}
