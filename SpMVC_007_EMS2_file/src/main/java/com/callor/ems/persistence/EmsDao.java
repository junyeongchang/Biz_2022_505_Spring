package com.callor.ems.persistence;

import com.callor.ems.model.EmsVO;

public interface EmsDao extends GenericDao<EmsVO, Long> {
	
	public void create_ems_table();

}
