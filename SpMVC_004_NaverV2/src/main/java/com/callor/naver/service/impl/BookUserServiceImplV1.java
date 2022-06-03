package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.naver.domain.BookUserVO;
import com.callor.naver.persistance.BookUserDao;
import com.callor.naver.service.BookUserService;

@Service("bookUserServiceV1")
public class BookUserServiceImplV1 implements BookUserService {
	
	private final BookUserDao bookUserDao;
	public BookUserServiceImplV1(BookUserDao bookUserDao) {
		this.bookUserDao = bookUserDao;
	}

	@Override
	public List<BookUserVO> selectAll() {
		// TODO Auto-generated method stub
		return bookUserDao.selectAll();
	}

	@Override
	public BookUserVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BookUserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookUserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
