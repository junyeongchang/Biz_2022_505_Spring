package com.callor.memo.service;

import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;

public interface FileUpService {
	
	public String insertMemoAndFile(MemoVO memoVO, MultipartFile file) throws Exception;

	public void updateMemoAndFile(MemoVO memoVO, MultipartFile file) throws Exception;

}
