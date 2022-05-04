package com.callor.school.persistance.impl;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.school.model.StudentVO;

public interface StudentDao {

	@Select(" select * from tbl_student ")
	public List<StudentVO> selectAll();
}
