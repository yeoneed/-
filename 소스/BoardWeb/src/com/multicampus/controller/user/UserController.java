package com.multicampus.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multicampus.biz.user.UserDAOJDBC;
import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 로그인 화면으로 이동
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		vo.setId("test");
		vo.setPassword("test");
		return "login";
	}
	
	// 로그인 처리
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) throws Exception {
		UserVO user = userService.getUser(vo);
		if(user != null) {
			session.setAttribute("user", user);
			// 리턴되는 뷰이름 앞에 "forward:"이나 "redirect:"이 붙으면 뷰 리졸버는 동작하지 않는다.
			return "forward:getBoardList.do";
		} else return "login";
	}
	
	// 로그아웃 처리
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();			
		return "redirect:/";
	}
	
	// 회원 가입 처리
	@RequestMapping("/insertUser.do")
	public String insertUser(UserVO vo, UserDAOJDBC dao) throws Exception {
		//dao.insertUser(vo);		
		return "redirect:/";
	}
}






