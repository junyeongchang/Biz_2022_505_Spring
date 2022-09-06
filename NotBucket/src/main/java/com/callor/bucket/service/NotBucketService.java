package com.callor.bucket.service;

import java.util.List;

import org.springframework.ui.Model;

import com.callor.bucket.model.NotBucketVO;
import com.callor.bucket.model.SearchPage;
import com.callor.bucket.model.UserInsertNotBucketVO;
import com.callor.bucket.persistance.NotBucketDao;

public interface NotBucketService extends NotBucketDao{

	void searchAndPage(Model model, SearchPage searchPage);

	List<NotBucketVO> searchAndPage(SearchPage searchPage);

	void userAndNotBucket(UserInsertNotBucketVO userInsertNotBucketVO);

	List<NotBucketVO> mySelectAll(String username);

	List<NotBucketVO> rankSelectAll();

	NotBucketVO findByRank();
}
