package com.bbs.web.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.web.DAO.userDAO;
import com.bbs.web.DTO.user.userDTO;

@WebServlet("/signUp")
public class signUpController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/view/user/signUp.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	      resp.setContentType("text/html; charset=UTF-8");
		String id = req.getParameter("id");
		String pass = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		userDTO us = new userDTO(id, pass, name, email);
		
		int result = userDAO.getInstance().join(us);
		
		resp.sendRedirect("login");
	}
}
