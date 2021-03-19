package list;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.web.DAO.listDAO;
import com.bbs.web.DTO.user.listDTO;
@WebServlet("/list")
public class ListController extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	      resp.setContentType("text/html; charset=UTF-8"); //한글써도 안깨지게
	listDAO DAO = new listDAO();
	//파라미터 받기 
	String page_=req.getParameter("p");
	String field_=req.getParameter("f");
	String query_=req.getParameter("q");
	
	//매개변수 초기화
	int page = 1;
	String field = "title";
	String query = "";
	
	
	   // null 값 보완 및 매개변수 입력
		if(page_ != null && !page_.equals("")) {
			page = Integer.parseInt(page_);
		}
		
		if(field_ != null && !field_.equals("")) {
			field = field_;
		}
		
		if(query_ != null && !query_.equals("")) {
			query = query_;
		}
	  
	 
	 System.out.println("field : "+page);
	 System.out.println("field : "+field);
	 System.out.println("query : "+query);
		
	 List<listDTO> list = DAO.getNoticeList(page, field, query);
	 
	 int count = 0;
	 
	 count = DAO.getNoticeCount(field, query);
	 req.setAttribute("list", list);
	 req.setAttribute("count", count);
	req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
	}

}
