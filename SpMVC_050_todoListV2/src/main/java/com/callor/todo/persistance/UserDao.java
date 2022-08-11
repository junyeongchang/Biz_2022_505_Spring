package com.callor.todo.persistance;

import java.util.List;

import com.callor.todo.model.AuthorVO;
import com.callor.todo.model.UserVO;

public interface UserDao extends GenericDao<UserVO, String> {
	/*
	 * tbl_authorities 테이블에서 
	 * username 에 해당하는 ROLE 리스트 select 하기
	 */
	public List<AuthorVO> select_role(String username);
}
