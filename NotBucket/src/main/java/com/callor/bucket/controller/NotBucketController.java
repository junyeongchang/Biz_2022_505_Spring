package com.callor.bucket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.bucket.model.NotBucketVO;
import com.callor.bucket.model.UserInsertNotBucketVO;
import com.callor.bucket.model.UserVO;
import com.callor.bucket.service.NotBucketService;

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
		UserVO loginUser = (UserVO) session.getAttribute("USER");
		long seq = notBucketService.insert(notBucketVO);
		UserInsertNotBucketVO userInsertNotBucketVO = UserInsertNotBucketVO.builder()
				 .b_seq(seq)
				 .username(loginUser.getUsername())
				 .build();
		notBucketService.userAndNotBucket(userInsertNotBucketVO);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(
			// 숫자형 매개변수를 사용하면서 400 오류를 방지하는 코드
			@RequestParam(name = "seq", required = false, defaultValue = "0") long b_seq, Model model) {

		NotBucketVO notBucketVO = notBucketService.findById(b_seq);
		
		model.addAttribute("NOTBUCKET", notBucketVO);
		return "notbucket/detail";
	}
	
	@RequestMapping(value="/recommend",method=RequestMethod.GET)
	public String update(@RequestParam("seq") long seq) {
		NotBucketVO notBucketVO = notBucketService.findById(seq);
		if(notBucketVO.getB_rec() == null) {
			notBucketVO.setB_rec(1L);
		} else if(notBucketVO.getB_rec() > 0) {
			notBucketVO.setB_rec(notBucketVO.getB_rec() + 1L);
		}
		notBucketService.update(notBucketVO);
		return "redirect:/notbucket/detail?seq=" + seq;
	}
}
