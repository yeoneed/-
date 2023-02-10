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
		System.out.println("�α��� ��� ó��");
		
		// 1. ����� �Է����� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAOJDBC dao = new UserDAOJDBC();
		UserVO user = dao.getUser(vo);
		
		// 3. ȭ�� �̵�
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			// �α��� ���� �ÿ� ���ǿ� ����� ������ ����Ѵ�. 
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			mav.setViewName("getBoardList.do");
		} else {
			mav.setViewName("login.jsp");
		}
		
		return mav;
	}

}
