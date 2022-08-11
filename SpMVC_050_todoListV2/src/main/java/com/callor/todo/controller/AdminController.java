package com.callor.todo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public String home(Principal principal) {
		return "admin/home";
	}
}
