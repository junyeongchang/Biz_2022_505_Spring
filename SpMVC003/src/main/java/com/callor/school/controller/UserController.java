package com.callor.school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.school.model.UserVO;
import com.callor.school.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @RequestMapping(value = "/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return null;
	}

	/*
	 * 1. login.form에서 username 과 password 받기
	 * 2. userVO에 담겨서 받게 된다.
	 * 3. userVO UserService.login 에게 전달한다.
	 * 4. userService.login() method는 username과 password 검사
	 * 5. 정상적인(username, password 가 일치) 정보이면
	 * 		나머지 user 정보를 userVO에 담아서 return
	 * 		만약 정상적인 사용자가 아니면 null을 return
	 * 
	 * 6. Controller.login.POST method 에는
	 * 		HttpSession 클래스가 매개변수로 설정한다.
	 * 7. 정상 사용자 정보이면(userVO 가 null 이 아니면)
	 * 		setAttribute() method를 사용하여 사용자 정보를
	 * 		변수에 settion 한다.
	 * 8. 정상 사용자가 아니면 removeAttribute() method르 사용하여
	 * 		변수를 제거해 버린다.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO userVO, HttpSession session, Model model) {
		// 로그인 폼에서 입력한 username, password는 userVO에 담겨
		// 이곳에 도착한다.

		// Server 와 view 사이에서 약속된 Pro
		log.debug(userVO.toString());

		String loginMessage = null;
		// 로그인 폼에서 전송된 데이터 중 username으로
		// findById() 즉 selectOne(username)을 실행한다.
		// 그리고 결과를 loginUserVO에 담는다
		// 결과는 null 이고, 
		// 정보가 있으면 관련데이터가 포함된 vo가 만들어 진다.
		UserVO loginUserVO = userService.findById(userVO.getUsername());
		// username 이 가입된 적이 없을때
		if (loginUserVO == null) {
			// 가입된 적이 없다는 key word를 생성하고
			loginMessage = "USERNAME FAIL";
		} else
		// username 은 있는데 password 가 다를 경우
		if (!loginUserVO.getPassword().equals(userVO.getPassword())) {
			// 비밀번호가 잘못되었다는 Key word를 생성하고
			loginMessage = "PASSWORD FAIL";
		}
		
		if (loginMessage == null) {
			session.setAttribute("USER", loginUserVO);
		} else {
			session.removeAttribute("USER");
		}
		
		// view 로 보낼 message Protocol 을 settion
		model.addAttribute("LOGIN_MESSAGE", loginMessage);

		return "user/login_ok";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.removeAttribute("USER");
		
		/*
		 * redirect:/user/login
		 * 
		 * 로그아웃이 끝나면
		 * web browser의 주소창에 /user/login 을 입력하고
		 * Enter를 눌러라
		 * 
		 */

		return "redirect:/user/login";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		
		/*
		 *  이 메서드를 요청하는 url은
		 *  /user/join 이다
		 *  return null 을 실행하면
		 *  return user/join 을 실행한 것과 같다.
		 *  view/user/join.jsp 를 rendering 하라는 의미
		 */
		return null;
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVO) {
		
		log.debug("JOIN");
		log.debug(userVO.toString());
		userService.join(userVO);
		
		
		return "redirect:/user/login";
		/*
		 * return "문자열" : forwarding
		 * => views/문자열.jsp 를 rendering 하라
		 * 
		 * return "redirect:/url" : pass, toss, redirect
		 * => 서버의 localhost:8080/url 을 다시 request 하라
		 * => web browse 주소창에 localhost:8080/url 을 입력하고 Enter를 누르는 것과 같은 효과
		 */
	}

	/*
	 * username 중복검사를 하기 위하여 보통 다음같은 요청을 수행한다.
	 * /user/idcheck?username=callor
	 * 
	 * fetch(`${rootPath}/user/idcheck/${username.value}`)
	 * 만약 username에 callor 입력했으면
	 * /user/idcheck/callor 처럼 요청 URL 만들어서 요청을 수행하라
	 * RestFul 방식
	 * 
	 * id를 email 주소로 사용할때 pathVarriable로 받을 경우
	 * dot(.) 이후의 문자열을 잘라버리는 현상이 있다
	 * 이때는 정규식(Rexp)를 사용하여 dot(.) 이후 문자열을 포함하여
	 * 변수에 저장하도록 변수를 수정
	 * 		{username:.+} 형식으로 지정한다.
	 */
	@ResponseBody
	@RequestMapping(value = "/idcheck/{username:.+}", method = RequestMethod.GET)
	public String idcheck(@PathVariable("username") String username) {
		
		UserVO userVO = userService.findById(username);

		// if(username.equalsIgnoreCase(userVO.getUsername()))
		//if(userVO.getName().equals(username)) {
		//	return "FAIL";
		//}else {
		//	return "OK";
		//}

		if(userVO == null) {
			return "OK";
		}else {
			return "FAIL";
		}
	}
}
