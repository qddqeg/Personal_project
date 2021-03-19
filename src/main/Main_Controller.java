package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.web.DAO.imgDAO;
import com.bbs.web.DTO.user.imgDTO;
@WebServlet("/main")
public class Main_Controller extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=UTF-8"); //한글써도 안깨지게
	List<imgDTO> list = imgDAO.getInstance().getImgList();
	
	req.setAttribute("plist", list);
	req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	
	}
}
