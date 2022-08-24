package com.callor.bucket.persistance;

import java.util.List;

import com.callor.bucket.model.NotBucketVO;
import com.callor.bucket.model.SearchPage;

public interface NotBucketDao extends GenericDao<NotBucketVO, Long>{

	List<NotBucketVO> searchAndPage(SearchPage searchPage);


}
