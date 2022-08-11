package com.callor.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.address.config.QualifyConfig;
import com.callor.address.model.AddressVO;
import com.callor.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	// setter 주입
//	@Autowired
//	private AddressService addrServicd;
	
	// 생성자 주입
	private final AddressService addrService;
	public HomeController(@Qualifier(QualifyConfig.SERVICE.ADDR_V1) AddressService addrService) {
		this.addrService = addrService;
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<AddressVO> addressList = addrService.selectAll();
		model.addAttribute("ADDRESSES", addressList);
		return "home";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(AddressVO address) {
		
//		log.debug("이름 : {} ",address.getA_name());
//		log.debug("전화번호 : " + address.getA_tel());
//		log.debug("주소 : {} ",address.getA_address());
//		log.debug("받은 데이터 : {}", address.toString());
		
		addrService.insert(address);
		return "redirect:/";
	}
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public String home(String a_name, String a_tel, String a_address) {
//		
//		log.debug("이름 : {} ",a_name);
//		log.debug("전화번호 : " + a_tel);
//		log.debug("주소 : {} ", a_address);
//		
//		return "home";
//	}
	
	// 요청 http://localhost:8080/address/detail?seq=3
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(@RequestParam ("seq") String strSeq, Model model) {
		log.debug("전달받은 seq 값 : {}",strSeq);
		long a_seq = Long.valueOf(strSeq);
		log.debug("전달받은 값 long으로 형변환 : {}", a_seq);
		
		AddressVO addressVO = addrService.findById(a_seq);
		model.addAttribute("ADDRESS", addressVO);
		return "detail";
	}
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String update(@RequestParam("seq") String strSeq, Model model) {
		long a_seq= Long.valueOf(strSeq);
		AddressVO addressVO = addrService.findById(a_seq);
		model.addAttribute("addrVO", addressVO);
		return "home";
	}
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(AddressVO address) {
		addrService.update(address);
		return "redirect:/";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@RequestParam("seq") String strSeq) {
		long a_seq= Long.valueOf(strSeq);
		addrService.delete(a_seq);
		return "redirect:/";
	}
}
