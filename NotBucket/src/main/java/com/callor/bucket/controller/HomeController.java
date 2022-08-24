package com.callor.bucket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.bucket.model.NotBucketVO;
import com.callor.bucket.model.SearchPage;
import com.callor.bucket.service.NotBucketService;

@Controller
public class HomeController {
	
	@Autowired
	private NotBucketService notBucketService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session, 
			@RequestParam(name = "pageno", required = false, defaultValue = "0") int pageno
			) {
		SearchPage searchPage = SearchPage.builder()
				.a_name("")
				.limit(10)
				.offset(pageno * 10)
				.build();
		// list
		searchPage.setCurrentPageNo(pageno);
		notBucketService.searchAndPage(model,searchPage);
		
		List<NotBucketVO> allNotBucketList = notBucketService.searchAndPage(searchPage);
		
		model.addAttribute("NOTBUCKETS", allNotBucketList);
		
		// mylist
		// UserVO loginUser = (UserVO) session.getAttribute("USER");
		
		
		// List<NotBucketVO> myNotBucketList =  notBucketService.findById();
		// model.addAttribute("LAYOUT", myNotBucketList);
		
		
		
		
		// ranklist
		
		
		
		
		return "home";
	}
}
