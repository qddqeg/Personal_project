package com.bbs.web.controller.user;

import java.io.IOException;
import com.bbs.command.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bbs.command.*;
import com.bbs.web.DAO.userDAO;

@WebServlet("/user/idCheck")
public class idCheckController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");	
		int check = userDAO.getInstance().idCheck(id);	
		req.setAttribute("check", check);
		req.setAttribute("id", id);
		req.getRequestDispatcher("/WEB-INF/view/user/idCheck.jsp").forward(req, resp);
	}

}
