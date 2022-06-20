package com.seasoning.app.service;

import java.io.IOException;
import java.util.List;

import com.seasoning.app.model.LocationVO;

public interface TourLocationService {

	public List<LocationVO> getSeoul_TourLocation() throws IOException;
	public List<LocationVO> getBusan_TourLocation() throws IOException;
	public List<LocationVO> getDeagu_TourLocation() throws IOException;
	public List<LocationVO> getIncheon_TourLocation() throws IOException;
	public List<LocationVO> getGwangju_TourLocation() throws IOException;
	public List<LocationVO> getDeajeon_TourLocation() throws IOException;
	public List<LocationVO> getUlsan_TourLocation() throws IOException;
	public List<LocationVO> getSejong_TourLocation() throws IOException;
	public List<LocationVO> getGGD_TourLocation() throws IOException;
	public List<LocationVO> getGWD_TourLocation() throws IOException;
	public List<LocationVO> getCBD_TourLocation() throws IOException;
	public List<LocationVO> getCND_TourLocation() throws IOException;
	public List<LocationVO> getGRBD_TourLocation() throws IOException;
	public List<LocationVO> getGRND_TourLocation() throws IOException;
	public List<LocationVO> getGSBD_TourLocation() throws IOException;
	public List<LocationVO> getGSND_TourLocation() throws IOException;
	public List<LocationVO> getJeju_TourLocation() throws IOException;
	

	public String getContentId() throws IOException;
	

}
