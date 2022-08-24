package com.callor.bucket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.bucket.model.NotBucketVO;
import com.callor.bucket.model.UserVO;
import com.callor.bucket.service.NotBucketService;
import com.callor.bucket.service.UserService;

@Controller
@RequestMapping(value="/notbucket")
public class NotBucketController {
	
	@Autowired
	private NotBucketService notBucketService;
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(Model model) {
		model.addAttribute("LAYOUT", "INSERT");
		return "home";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(NotBucketVO notBucketVO, Model model, HttpSession session) {
		UserVO userVO = new UserVO();
		session.setAttribute("USER", userVO);
		notBucketService.insert(notBucketVO);
		return "redirect:/";
	}
}
