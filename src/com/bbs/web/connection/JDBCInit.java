package com.bbs.web.connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

//jdbc 셋팅
public class JDBCInit extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
