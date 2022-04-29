package com.callor.app.service;

import com.callor.app.domain.StudentVO;

public interface StudentService {

	// 데이터 추가
	public int insert(StudentVO studentVO);

	// 전체리스트 가져오기
	public StudentVO[] selectAll();

	// 특정 데이터 가져오기
	public StudentVO findById(String stNum);
}
