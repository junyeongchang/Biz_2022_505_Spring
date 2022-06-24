package com.callor.ems.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.ems.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileUpServiceImplV1 implements FileUpService {

	@Autowired
	private String upPath;

	private final ResourceLoader resourceLoader;

	public FileUpServiceImplV1(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	public String fileUp(MultipartFile file) {
		if (file == null) {
			return null;
		}

		log.debug("업로드 폴더 {} ", upPath);
		String fileName = file.getOriginalFilename();

		File dir = new File(upPath);

		if (!dir.exists()) {
			dir.mkdirs();
		}

		File upLoadFile = new File(upPath, fileName);

		try {
			file.transferTo(upLoadFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileName;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest mFile) {
		
		return null;
	}

}
