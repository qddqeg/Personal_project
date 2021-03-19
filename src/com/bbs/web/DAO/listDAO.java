package com.bbs.web.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbs.web.DTO.user.CommentDTO;
import com.bbs.web.DTO.user.imgDTO;
import com.bbs.web.DTO.user.listDTO;
import com.bbs.web.connection.ConnectionProvider;
import com.bbs.web.connection.jdbcUtil;







public class listDAO {
	private static listDAO instance = new listDAO();
	
	public static listDAO getInstance() {
		return instance;
	}
	
	//글쓰기
	public int insertNotice(listDTO list) {
		Connection con = null;
		PreparedStatement psmt =null;
		ResultSet rs = null;
		int value = 0;
				
		try {
			String sql="insert into notice(title,writer_id,content,files,pubflag) "
					+ " values(?,?,?,?,?)";
			
			con = ConnectionProvider.getConnection();
			psmt =con.prepareStatement(sql);
			
			psmt.setString(1, list.getTitle());
			psmt.setString(2, list.getWriterId());
			psmt.setString(3, list.getContent());
			psmt.setString(4, list.getFiles());
			String pub ="N";
			if(list.getPub()==true) {
				pub ="Y";
			}
			psmt.setString(5,pub );
			 value=psmt.executeUpdate();
		
			
			
		} catch (Exception e) {
			e.printStackTrace();

	} finally {
		jdbcUtil.close(rs);
		jdbcUtil.close(psmt);
		jdbcUtil.close(con);
	}
		
		
		return value;
	}
	//검색 & 페이징
	public List<listDTO> getNoticeList(int page,String field, String query) { //글 조회
		int start = 1 + (page - 1) * 10; // 1, 11, 21 ,31, 41
		int end = page * 10; // 10 20 30 40 50

		Connection con = null;
		PreparedStatement psmt =null;
		ResultSet rs = null;
		List<listDTO> list = new ArrayList<listDTO>();
		
		try {
			
			String sql = "Select *   "
					+ "                  from(Select @rownum:=@rownum+1 as num , n.*"
					+ "                   from (select *"
					+ "                      from notice "
					+ "					  where "+field+" like ? "
					+ "                    order by regdate desc)n,"
					+ "                    (select @rownum:=0)v)num"
					+ "                    Where num.num between ? and ? ;";
		
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1,"%"+query+"%");
			psmt.setInt(2, start);
			psmt.setInt(3, end);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String writerid = rs.getString("writer_id");
				Date regDate = rs.getDate("regdate");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				String files = rs.getString("files");
				String pubflag=rs.getString("pubflag");
				boolean pub = false;
				if(pubflag.equals("Y")) {
					pub =true;
				}

				listDTO DTO= new listDTO(id, title, writerid, content, regDate, hit, files,pub);

				list.add(DTO);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(con);
		}
		return list;
		
	}
	//페이징 카운터 
	public int getNoticeCount(String field, String query) {
		Connection con = null;
		PreparedStatement psmt =null;
		ResultSet rs = null;
		int count = 0;

		String sql =  "Select count(num.id) as count " 
				 + "    from (Select @rownum:=@rownum+1 as num , n.*" 
				 + "        from(select *"
				 + "               From notice"
				 + "			  where "+field+" like ?"  // %검색어% 
				 + "		      order by regdate desc)n"
				 + "        Where (@rownum:=0)=0) num " ;
			
			

		
		try {
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1,"%"+query+"%");
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("count");
				System.out.println("count"+count);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(con);
		}
		return count;
	}
	//조회수 카운터
	public void countNoticeHit(int id) {
		Connection con = null;
		PreparedStatement psmt =null;
		
		try {
			String sql="update notice set hit=(hit+1) where id = ?";
			con = ConnectionProvider.getConnection();
			psmt =con.prepareStatement(sql);
			
			psmt.setInt(1,id);
			psmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
	}finally {
		jdbcUtil.close(psmt);
		jdbcUtil.close(con);
	}
	
	}

	public listDTO getNoticeDetail(int id) {
		Connection con = null;
		PreparedStatement psmt =null; 
		ResultSet rs= null;
		listDTO DTO =null;
		
		try {
			String sql = "Select * from notice where id=?";
			
			con = ConnectionProvider.getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
				String title = rs.getString("title");
				String writerid = rs.getString("writer_id");
				Date regDate = rs.getTimestamp("regdate");
				String content = rs.getString("content");
				int hit = rs.getInt("hit");
				String files = rs.getString("files");
				String pubflag=rs.getString("pubflag");
				boolean pub = false;
				if(pubflag.equals("Y")) {
					pub =true;
				}

				DTO = new listDTO(id, title, writerid, content, regDate, hit, files,pub);
				System.out.println("id : "+id);
				System.out.println("title : "+title);
				System.out.println("writerid : "+writerid);
				System.out.println("content : "+content);
				System.out.println("regDate : "+regDate);
				System.out.println("hit : "+hit);
				System.out.println("files : "+files);
				System.out.println("pub : "+pub);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(con);
		}
		return DTO;
	
		
	}
public int getNoticeCount(int id) {
		
		return 0;
	}
public int getNoticeCommentCount(int id) {
	int count = 0;
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs= null;
	
	
try {
	String sql = "select count(id) as count from comment where mid =?";
		
		con = ConnectionProvider.getConnection();
		psmt =con.prepareStatement(sql);
		psmt.setInt(1,id);
		rs = psmt.executeQuery();
	
		if(rs.next())
			count =rs.getInt("count");
	} catch (Exception e) {
		e.printStackTrace();
}finally {
	jdbcUtil.close(rs);
	jdbcUtil.close(psmt);
	jdbcUtil.close(con);
}
	return count;
}
public List<imgDTO> getImgcommentList(int pid) {
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	List<imgDTO> list = new ArrayList<imgDTO>();
	
	try {
		String sql ="select * from comment where mid=? order by regdate desc ";
		
		con = ConnectionProvider.getConnection();
		psmt = con.prepareStatement(sql);
		psmt.setInt(1, pid);
		rs = psmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			int mid = rs.getInt("mid");
			String writerid = rs.getString("writer");
			Date regDate = rs.getDate("regdate");
			String comment = rs.getString("comment");
		

			//imgDTO nc = new imgDTO(id,mid,writerid,regDate,comment);

			//list.add(nc);
		}
	} catch (Exception e) {
		e.printStackTrace();

	}finally {
		jdbcUtil.close(rs);
		jdbcUtil.close(psmt);
		jdbcUtil.close(con);
	}
	return list;

}
public int insertNoticeComment(CommentDTO nc) {
	int result = 0;
	Connection con = null;
	PreparedStatement psmt = null;
	
	try {
		String sql = "insert into comment(mid,writer,comment) values(?,?,?)";
		
		con = ConnectionProvider.getConnection();
		psmt =con.prepareStatement(sql);
		psmt.setInt(1,nc.getMid());
		psmt.setString(2,nc.getWriter());
		psmt.setString(3,nc.getComment());
		result=psmt.executeUpdate();
	
	} catch (Exception e) {
		e.printStackTrace();
}finally {
	jdbcUtil.close(psmt);
	jdbcUtil.close(con);
}
	
	return result;
	
}

//댓글 리스트
public List<CommentDTO> getCommentList(int mid) { //글 조회

	Connection con = null;
	PreparedStatement psmt =null;
	ResultSet rs = null;
	List<CommentDTO> list = new ArrayList<CommentDTO>();
	
	try {
		
		String sql = "select * from comment where mid=?";
		con = ConnectionProvider.getConnection();
		psmt = con.prepareStatement(sql);
		psmt.setInt(1, mid);
		rs = psmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			mid = rs.getInt("mid");
			String comment = rs.getString("comment");
			Date regDate = rs.getDate("regdate");
			String writerid = rs.getString("writer");
			
		

			CommentDTO nc = new CommentDTO(id,mid,comment,regDate,writerid);

			list.add(nc);
		}
	} catch (Exception e) {
		e.printStackTrace();

	}finally {
		jdbcUtil.close(rs);
		jdbcUtil.close(psmt);
		jdbcUtil.close(con);
	}
	return list;


}
}
