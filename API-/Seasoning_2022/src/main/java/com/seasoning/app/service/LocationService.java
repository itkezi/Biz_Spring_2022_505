package com.seasoning.app.service;

import java.io.IOException;
import java.util.List;

import com.seasoning.app.model.LocationVO;

public interface LocationService {

	public List<LocationVO> getSeoulLocation() throws IOException;
	public List<LocationVO> getBusanLocation() throws IOException;
	public List<LocationVO> getDeaguLocation() throws IOException;
	public List<LocationVO> getIncheonLocation() throws IOException;
	public List<LocationVO> getGwangjuLocation() throws IOException;
	public List<LocationVO> getDeajeonLocation() throws IOException;
	public List<LocationVO> getUlsanLocation() throws IOException;
	public List<LocationVO> getSejongLocation() throws IOException;
	
	public List<LocationVO> getGGDLocation() throws IOException;
	public List<LocationVO> getGWDLocation() throws IOException;
	public List<LocationVO> getCBDLocation() throws IOException;
	public List<LocationVO> getCNDLocation() throws IOException;
	public List<LocationVO> getGRBDLocation() throws IOException;
	public List<LocationVO> getGRNDLocation() throws IOException;
	public List<LocationVO> getGSBDLocation() throws IOException;
	public List<LocationVO> getGSNDLocation() throws IOException;
	public List<LocationVO> getJejuLocation() throws IOException;

}
