package com.callor.bucket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.bucket.model.NotBucketVO;
import com.callor.bucket.model.SearchPage;
import com.callor.bucket.model.UserInsertNotBucketVO;
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
	public NotBucketVO findByRank() {
		return notBucketDao.findByRank();
	}
	
	@Override
	public List<NotBucketVO> rankSelectAll() {
		// TODO Auto-generated method stub
		return notBucketDao.rankSelectAll();
	}
	
	@Override
	public List<NotBucketVO> mySelectAll(String username) {
		// TODO Auto-generated method stub
		return notBucketDao.mySelectAll(username);
	}

	@Override
	public NotBucketVO findById(Long id) {
		// TODO Auto-generated method stub
		return notBucketDao.findById(id);
	}

	@Override
	public int insert(NotBucketVO vo) {
		notBucketDao.insert(vo);
		Long seq = vo.getB_seq();
		return seq.intValue();
	}
	
	@Override
	public int update(NotBucketVO vo) {
		
		return notBucketDao.update(vo);
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
				
				String search = searchPage.getSearch();
				search = search == null ? "" : search;
				searchPage.setSearch(search);
				
				List<NotBucketVO> addrList = notBucketDao.searchAndPage(searchPage);
				
				long totalCount = addrList.size();
				if(totalCount < 1) return;
				
				long finalPageNo = totalCount / LIST_PER_PAGE;
				// 화면 하단의 페이지번호를 클릭했을때 전달되는 값
				long currentPageNo = searchPage.getCurrentPageNo();
				
				// 삼항 연산자를 사용할때
				currentPageNo = currentPageNo > 1 ?
								(currentPageNo > finalPageNo 
											? finalPageNo 
											: currentPageNo
								)
								: 1;
				// 일반적인 if 문을 사용할때
				if(currentPageNo > finalPageNo) {
					currentPageNo = finalPageNo;
				}
				if(currentPageNo < 1) {
					currentPageNo = 1;
				}
				
				// 선택된 페이지번호에 따라 화면하단 번호 리스트를 유동적으로
				// 보여주기 위한 연산
				long startPageNo = (currentPageNo / PAGE_NO_COUNT) * PAGE_NO_COUNT;
				startPageNo = startPageNo < 1 ? 1 : startPageNo;
				
				long endPageNo = startPageNo + PAGE_NO_COUNT;
				
				endPageNo = endPageNo > finalPageNo ? finalPageNo : endPageNo;
				
				searchPage.setStartPageNo(startPageNo);
				searchPage.setEndPageNo(endPageNo);
				searchPage.setLimit(LIST_PER_PAGE);
				searchPage.setOffset((currentPageNo - 1) * PAGE_NO_COUNT);
				searchPage.setFinalPageNo(finalPageNo);
				
				// JSP 롤 보내기 위해서 model 에 담기
				model.addAttribute("PAGE", searchPage);
	}

	@Override
	public List<NotBucketVO> searchAndPage(SearchPage searchPage) {
		// TODO Auto-generated method stub
		return notBucketDao.searchAndPage(searchPage);
	}

	@Override
	public void userAndNotBucket(UserInsertNotBucketVO userInsertNotBucketVO) {
		notBucketDao.userAndNotBucket(userInsertNotBucketVO);
		
	}

	

}
