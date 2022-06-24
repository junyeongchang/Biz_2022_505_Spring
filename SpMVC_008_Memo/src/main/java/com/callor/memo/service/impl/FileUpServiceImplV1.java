package com.callor.memo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.FileUpService;

public class FileUpServiceImplV1 implements FileUpService{

	@Autowired
	private String upPath;

	private final ResourceLoader resLoader;
	public FileUpServiceImplV1(ResourceLoader resLoader) {
		this.resLoader = resLoader;
	}

	@Override
	public String insertMemoAndFile(MemoVO memoVO, MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMemoAndFile(MemoVO memoVO, MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
