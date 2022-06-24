package com.callor.memo.persistence;

import com.callor.memo.model.MemoVO;

public interface ListDao extends GenericDao<MemoVO, Long> {

	public void create_memo_table();

	
}
