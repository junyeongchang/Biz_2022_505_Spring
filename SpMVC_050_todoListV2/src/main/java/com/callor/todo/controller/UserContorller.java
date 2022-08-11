package com.callor.todo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserContorller {
	
	@RequestMapping(value="/join" , method=RequestMethod.GET)
	public String join() {
		
		return "user/join";
	}
	
	@RequestMapping(value="/join" , method=RequestMethod.POST)
	public String join(@ModelAttribute UserVO userVO) {
		
		// 3번째 방법 권장 
		log.debug(userVO.toString());
		log.debug("회원가입 데이터 : " + userVO);
		log.debug("회원가입 데이터 : {}", userVO);
		log.debug("회원가입 데이터 : {} {}", userVO, userVO);
		
		return "user/join";
	}
	
	// localhost:8080/context/user/login
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String login(String error, Model model) {
		model.addAttribute("error", error);
		return "user/login";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Principal principal) {
		
		return "user/mypage";
	}

}
