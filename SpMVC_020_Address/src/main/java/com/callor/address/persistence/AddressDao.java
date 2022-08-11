package com.callor.address.persistence;

import java.util.List;

import com.callor.address.model.AddressVO;

public interface AddressDao {
	public List<AddressVO> selectAll();

	public AddressVO findById(long seq);

	public int insert(AddressVO address);

	public int update(AddressVO address);

	public int delete(long seq);
	
	public void create_addr_table();
}
