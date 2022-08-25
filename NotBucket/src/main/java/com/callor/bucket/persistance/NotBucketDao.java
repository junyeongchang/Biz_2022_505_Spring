package com.callor.bucket.persistance;

import java.util.List;

import com.callor.bucket.model.NotBucketVO;
import com.callor.bucket.model.SearchPage;
import com.callor.bucket.model.UserInsertNotBucketVO;

public interface NotBucketDao extends GenericDao<NotBucketVO, Long>{

	List<NotBucketVO> searchAndPage(SearchPage searchPage);

	void userAndNotBucket(UserInsertNotBucketVO userInsertNotBucketVO);

	List<NotBucketVO> mySelectAll(String username);

	List<NotBucketVO> rankSelectAll();


}
