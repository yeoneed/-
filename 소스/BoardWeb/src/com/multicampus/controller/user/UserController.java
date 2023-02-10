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
	
	// �α��� ȭ������ �̵�
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		vo.setId("test");
		vo.setPassword("test");
		return "login";
	}
	
	// �α��� ó��
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) throws Exception {
		UserVO user = userService.getUser(vo);
		if(user != null) {
			session.setAttribute("user", user);
			// ���ϵǴ� ���̸� �տ� "forward:"�̳� "redirect:"�� ������ �� �������� �������� �ʴ´�.
			return "forward:getBoardList.do";
		} else return "login";
	}
	
	// �α׾ƿ� ó��
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();			
		return "redirect:/";
	}
	
	// ȸ�� ���� ó��
	@RequestMapping("/insertUser.do")
	public String insertUser(UserVO vo, UserDAOJDBC dao) throws Exception {
		//dao.insertUser(vo);		
		return "redirect:/";
	}
}






