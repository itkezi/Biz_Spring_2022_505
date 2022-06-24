package com.callor.ems.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.ems.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUPServiceImplV1 implements FileUpService {
	
	private final String upLoadFolder;
	
	public FileUPServiceImplV1(String upLoadFolder) {
		this.upLoadFolder = upLoadFolder;
	}
	
	@Autowired
	private String upPath;

	@Override
	public String fileUp(MultipartFile file) {
		
		if(file == null) {
			return null;
		}
		
		File dir = new File(upLoadFolder);
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		String fileName = file.getOriginalFilename();
		
		String strUUID = UUID.randomUUID().toString();
		
		fileName = String.format("%s-%s", strUUID, fileName);
		log.debug("변경된 파일 이름 {}", fileName);
		
		File upLoadFile = new File(upLoadFolder,fileName);
		
		try {
			file.transferTo(upLoadFile);
		} catch (IllegalStateException | IOException e) {
		}
		
		return null;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest mFile) {
		return null;
	}
	
	

}
