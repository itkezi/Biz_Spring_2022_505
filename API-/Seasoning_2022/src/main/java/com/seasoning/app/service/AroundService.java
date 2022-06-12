package com.seasoning.app.service;

import java.io.IOException;
import java.util.List;

import com.seasoning.app.model.AroundVO;

public interface AroundService {
	
	public List<AroundVO> getDeaguAround()throws IOException;
	public List<AroundVO> getGangwon1Around()throws IOException;
	public List<AroundVO> getGangwon2Around()throws IOException;
	public List<AroundVO> getGimcheonAround()throws IOException;
	public List<AroundVO> getIncheonAround()throws IOException;
	public List<AroundVO> getJejuAround()throws IOException;
	public List<AroundVO> getJeonbukAround()throws IOException;
	public List<AroundVO> getPohangAround()throws IOException;
	public List<AroundVO> getSeongnamAround()throws IOException;
	public List<AroundVO> getSuwan_ssAround()throws IOException;
	public List<AroundVO> getSuwonAround()throws IOException;
	public List<AroundVO> getUlsanAround()throws IOException;
}
