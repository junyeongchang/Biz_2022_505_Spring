package com.callor.bucket.service;

import com.callor.bucket.model.UserVO;
import com.callor.bucket.persistance.UserDao;

public interface UserService extends UserDao{
	public UserVO login(UserVO userVO);
}
