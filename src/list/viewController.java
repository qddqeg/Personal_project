package list;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.web.DAO.imgDAO;
import com.bbs.web.DTO.user.imgDTO;
@WebServlet("/view")
public class viewController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8"); //한글써도 안깨지게
		
	   String pid= req.getParameter("pid");
	    
	    
	    imgDTO DTO = imgDAO.getInstance().getImgDetail(pid);
	
	req.setAttribute("ph", DTO);
	req.getRequestDispatcher("/WEB-INF/view.jsp").forward(req, resp);
	}
}
