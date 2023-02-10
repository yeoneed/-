package com.multicampus.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.user.UserDAOJDBC;
import com.multicampus.biz.user.UserVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인 기능 처리");
		
		// 1. 사용자 입력정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAOJDBC dao = new UserDAOJDBC();
		UserVO user = dao.getUser(vo);
		
		// 3. 화면 이동
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			// 로그인 성공 시에 세션에 사용자 정보를 등록한다. 
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			mav.setViewName("getBoardList.do");
		} else {
			mav.setViewName("login.jsp");
		}
		
		return mav;
	}

}
