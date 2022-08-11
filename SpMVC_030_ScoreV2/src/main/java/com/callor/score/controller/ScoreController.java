package com.callor.score.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.score.model.StudentVO;
import com.callor.score.service.ScoreService;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/score")
public class ScoreController {
	
	private final StudentService stService;
	private final ScoreService scServicd;

	
	public ScoreController(StudentService stService, ScoreService scServicd) {
		this.stService = stService;
		this.scServicd = scServicd;
	}


	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(String st_num, Model model) {
		StudentVO student = stService.findById(st_num);
		model.addAttribute("STUDENT", student);
		return "score/input";
	}
	
	
	/*
	 * 한개의 form 에 다수의 input 가 같은이름으로 존재할 경우
	 * Controller에서 데이터를 받을때 문자열 배열로 데이터를 받는다
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(String st_num, String[] sb_code, String[]sc_score) {
		for(int i=0; i<sb_code.length; i++) {
			log.debug("받은데이터 {} {} {}", st_num, sb_code, sc_score);
		}
		return "redirect:/student/datail?st_num" + st_num;
	}

}
