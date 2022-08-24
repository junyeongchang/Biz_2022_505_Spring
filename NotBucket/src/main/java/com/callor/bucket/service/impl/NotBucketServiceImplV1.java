package com.callor.bucket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.bucket.model.NotBucketVO;
import com.callor.bucket.model.SearchPage;
import com.callor.bucket.persistance.NotBucketDao;
import com.callor.bucket.service.NotBucketService;

@Service
public class NotBucketServiceImplV1 implements NotBucketService {
	
	@Autowired
	private NotBucketDao notBucketDao;
	
	@Override
	public List<NotBucketVO> selectAll() {
		// TODO Auto-generated method stub
		return notBucketDao.selectAll();
	}

	@Override
	public NotBucketVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(NotBucketVO vo) {
		return notBucketDao.insert(vo);
	}

	@Override
	public int update(NotBucketVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	// 한 페이지에 보여질 데이터 리스트 개수
		private static final long LIST_PER_PAGE = 10;
		// 화면 하단에 페이지 번호 출력 개수
		private static final long PAGE_NO_COUNT = 10;
	@Override
	public void searchAndPage(Model model, SearchPage searchPage) {
		// pagination을 구현하기 위하여 전체 데이터 가져오기로
				// 개수를 임시로 세팅
				searchPage.setOffset(0);
				searchPage.setLimit(notBucketDao.selectAll().size());

				List<NotBucketVO> addrList = notBucketDao.searchAndPage(searchPage);
				
				long totalCount = addrList.size();
				if(totalCount < 1) return;
				searchPage.setListPerPage(10);
				searchPage.setPageNoCount(10);
				
				long finalPageNo = totalCount / searchPage.getListPerPage();
				searchPage.setFinalPageNo(finalPageNo);
				
				if(searchPage.getCurrentPageNo() > finalPageNo)
					searchPage.setCurrentPageNo(finalPageNo) ;
				
				if(searchPage.getCurrentPageNo() < 1)
					searchPage.setCurrentPageNo(1);
				
				long startPageNo = ((searchPage.getCurrentPageNo() - 1) 
						/ searchPage.getPageNoCount()) 
						* searchPage.getPageNoCount();
				
				long endPageNo = startPageNo + searchPage.getPageNoCount() - 1;
				
				searchPage.setStartPageNo(startPageNo);
				searchPage.setEndPageNo(endPageNo);
				searchPage.setLimit(searchPage.getPageNoCount());
				searchPage.setOffset(searchPage.getCurrentPageNo() 
						* searchPage.getPageNoCount());
				
				model.addAttribute("PAGE",searchPage);;
						
	}

	@Override
	public List<NotBucketVO> searchAndPage(SearchPage searchPage) {
		// TODO Auto-generated method stub
		return notBucketDao.searchAndPage(searchPage);
	}

}
