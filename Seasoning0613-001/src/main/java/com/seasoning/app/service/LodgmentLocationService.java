package com.seasoning.app.service;

import java.io.IOException;
import java.util.List;

import com.seasoning.app.model.LocationVO;

public interface LodgmentLocationService {

	public List<LocationVO> getSeoul_LodgmentLocation() throws IOException;
	public List<LocationVO> getBusan_LodgmentLocation() throws IOException;
	public List<LocationVO> getDeagu_LodgmentLocation() throws IOException;
	public List<LocationVO> getIncheon_LodgmentLocation() throws IOException;
	public List<LocationVO> getGwangju_LodgmentLocation() throws IOException;
	public List<LocationVO> getDeajeon_LodgmentLocation() throws IOException;
	public List<LocationVO> getUlsan_LodgmentLocation() throws IOException;
	public List<LocationVO> getSejong_LodgmentLocation() throws IOException;
	public List<LocationVO> getGGD_LodgmentLocation() throws IOException;
	public List<LocationVO> getGWD_LodgmentLocation() throws IOException;
	public List<LocationVO> getCBD_LodgmentLocation() throws IOException;
	public List<LocationVO> getCND_LodgmentLocation() throws IOException;
	public List<LocationVO> getGRBD_LodgmentLocation() throws IOException;
	public List<LocationVO> getGRND_LodgmentLocation() throws IOException;
	public List<LocationVO> getGSBD_LodgmentLocation() throws IOException;
	public List<LocationVO> getGSND_LodgmentLocation() throws IOException;
	public List<LocationVO> getJeju_LodgmentLocation() throws IOException;
	
	
	public String getContentId() throws IOException;
	

}
