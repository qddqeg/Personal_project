package list;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.web.DAO.listDAO;
import com.bbs.web.DTO.user.CommentDTO;
import com.bbs.web.DTO.user.listDTO;



@WebServlet("/detail")
public class DetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);

		listDAO DAO = new listDAO();
		DAO.countNoticeHit(id); // hit 카운트
		listDTO DTO = DAO.getNoticeDetail(id); // 페이지 호출
		
		CommentDTO nc = new CommentDTO();
		

		req.setAttribute("DTO", DTO);
		
		int comCount = DAO.getNoticeCount(id);
		comCount = DAO.getNoticeCommentCount(id);
		if(comCount != 0) {
			List<CommentDTO> list =DAO.getCommentList(id);
			
			req.setAttribute("comList", list); //list 보내기
			
		}
		req.setAttribute("count", comCount); //조회 된 목록 갯수
		req.getRequestDispatcher("/WEB-INF/detail.jsp").forward(req, res);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		int result=0;
		String comment = req.getParameter("comment");
		String pId= req.getParameter("pageID");
		int pageID = Integer.parseInt(pId);
		String writer =req.getParameter("writer");
		
		listDAO DAO = new listDAO();
		CommentDTO nc = new CommentDTO();
		
		nc.setMid(pageID);
		nc.setComment(comment);
		nc.setWriter(writer);
		
		
		result=DAO.insertNoticeComment(nc);
		
		resp.sendRedirect("detail?id="+pId);//디테일 한테  id를 가지고 가라 
		
	}
}
