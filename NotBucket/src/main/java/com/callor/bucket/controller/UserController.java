package com.callor.bucket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.bucket.model.UserVO;
import com.callor.bucket.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("LAYOUT","JOIN");
		return "home";		
	}
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVO userVO) {
		userService.insert(userVO);
		return "redirect:/home";		
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("LAYOUT","LOGIN");
		return "home";		
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(UserVO userVO) {
		return "redirect:/";		
	}
}
