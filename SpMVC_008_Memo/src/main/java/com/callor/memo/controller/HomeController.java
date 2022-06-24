package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.ListService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	private ListService listService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<MemoVO> memoList = listService.selectAll();
		model.addAttribute("memoList", memoList);
		return "home";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("memoVO") MemoVO memoVO, Model model) {
		model.addAttribute("memoVO", memoVO);
		return "/memo/insert";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(
			@ModelAttribute("memoVO") MemoVO memoVO, 
			@RequestParam("image")  MultipartFile file) {
		
		try {
			listService.insertMemoAndFile(memoVO, file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/{seq}/detail", method=RequestMethod.GET)
	public String detail(@PathVariable("seq") long seq, Model model) {
		
		MemoVO memoVO= listService.findById(seq);
		model.addAttribute("memoVO",memoVO);
		log.debug(memoVO.toString());
		return "/memo/detail";
	}
	
	@RequestMapping(value="/{seq}/update", method=RequestMethod.GET)
	public String update(@PathVariable("seq") long seq, Model model) {
		
		MemoVO memoVO= listService.findById(seq);
		model.addAttribute("memoVO",memoVO);
		log.debug(memoVO.toString());
		return "/memo/insert";
	}
	@RequestMapping(value="/{seq}/update", method=RequestMethod.POST)
	public String update(@PathVariable("seq") long seq,
			@ModelAttribute("memoVO") MemoVO memoVO, 
			@RequestParam("image")  MultipartFile file) {
		
		try {
			listService.updateMemoAndFile(memoVO, file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/{seq}/detail";
	}
	
	@RequestMapping(value="/{seq}/delete")
	public String delete(@PathVariable("seq") long seq) {
		
		listService.delete(seq);
		
		return "redirect:/";
	}

	@ModelAttribute("memoVO")
	private MemoVO memoVO() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		MemoVO memoVO = MemoVO.builder().m_date(dayFormat.format(date)).m_time(timeFormat.format(date)).build();
		return memoVO;
	}

}
