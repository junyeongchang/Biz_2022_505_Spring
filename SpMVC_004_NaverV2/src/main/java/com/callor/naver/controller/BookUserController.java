package com.callor.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.domain.BookUserVO;
import com.callor.naver.service.BookUserService;

@Controller
@RequestMapping(value = "user")
public class BookUserController {

	private final BookUserService bookUserService;

	public BookUserController(@Qualifier("bookUserServiceV1") BookUserService bookUserService) {
		this.bookUserService = bookUserService;
	}

	@RequestMapping(value = "/list")
	public String bookList(Model model) {
		List<BookUserVO> bookUserList = bookUserService.selectAll();
		model.addAttribute("BOOKS",bookUserList);
		return null;
	}

	@RequestMapping(value = "/bookUpdate")
	public String bookUpdate(Model model) {
		return "/list";
	}

	@RequestMapping(value = "/bookUpdate", method = RequestMethod.POST)
	public String bookUpdate() {
		return null;
	}

}
