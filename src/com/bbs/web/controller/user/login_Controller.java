package com.bbs.web.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bbs.web.DAO.userDAO;


	@WebServlet("/login")
	public class login_Controller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("userID");
		String pass=req.getParameter("userPASS");
		 HttpSession session = req.getSession();
		
		int result = userDAO.getInstance().login(id, pass);
		if(result==1) {
			System.out.println("로그인성공");
			session.setAttribute("ID", id);
		}else {
			System.out.println("로그인실패");
		}
		
		resp.sendRedirect("main");
	}
}
