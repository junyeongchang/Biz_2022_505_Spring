package com.callor.images.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.images.model.BBsVO;
import com.callor.images.persistance.BBsDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@Configuration
@RequestMapping(value="/bbs")
public class BBsController {
	
	@Autowired
	private BBsDao bbsDao;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(Model model) {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		
		BBsVO bbsVO = BBsVO.builder()
					  .b_date(dateFormat.format(date))
					  .b_time(timeFormat.format(date))
					  .b_writer("callor")
					  .build();
		model.addAttribute("BBS",bbsVO);
		
		return "bbs/input";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(BBsVO bbsVO) {
		
		log.debug("=".repeat(100));
		log.debug("insert  전  {}", bbsVO.getB_seq());
//		bbsDao.insert(bbsVO);
		bbsDao.insert(bbsVO);
		log.debug("insert  후  {}", bbsVO.getB_seq());
		
		return "redirect:/";
		
	}
}
