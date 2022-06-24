package com.callor.memo.service;

import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistence.ListDao;

public interface ListService extends ListDao {
	
	String insertMemoAndFile(MemoVO memoVO, MultipartFile file) throws Exception;

	void updateMemoAndFile(MemoVO memoVO, MultipartFile file) throws Exception;

}
