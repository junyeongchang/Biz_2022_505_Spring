package com.callor.bucket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.bucket.model.UserVO;
import com.callor.bucket.persistance.UserDao;
import com.callor.bucket.service.UserService;

@Service
public class UserServiceImplV1 implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder pass;

	@Override
	public UserVO login(UserVO userVO) {
		String username = userVO.getUsername();
		String password = userVO.getPassword();

		UserVO joinUserVO = userDao.findById(username);

		if (joinUserVO != null) {
			boolean bYes = pass.matches(password, joinUserVO.getPassword());
			if (bYes == false) {
				return null;
			}
		}
		return joinUserVO;
	}

	@Override
	public int insert(UserVO vo) {
		String encPassword = pass.encode(vo.getPassword());
		vo.setPassword(encPassword);
		userDao.insert(vo);
		return 0;
	}

	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
