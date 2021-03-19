package com.bbs.web.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bbs.web.DTO.user.userDTO;
import com.bbs.web.connection.ConnectionProvider;
import com.bbs.web.connection.jdbcUtil;

public class userDAO {
	private static userDAO instance = new userDAO();

	public static userDAO getInstance() {
		return instance;
	}

	// ID 중복 체크
	public int idCheck(String userID) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int value = 0;

		try {
			String sql = "select userID from user where userID = ?";

			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userID);
			System.out.println(psmt);
			rs = psmt.executeQuery();

			if (rs.next())
				value = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return value;
	}

	public int join(userDTO user) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		int value = 0;

		try {
			String sql = "INSERT INTO user (userID,userPASS,userName,userEmail) VALUES(?, ?, ?, ?)";

			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserID());
			psmt.setString(2, user.getUserPASS());
			psmt.setString(3, user.getUserName());
			psmt.setString(4, user.getUserEmail());
			psmt.executeUpdate();
			value = 1;
		}
		 catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return value;
	}

	public int login(String id, String pass) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			String sql = "select userPASS from user where userID =?";
			conn = ConnectionProvider.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(pass)) {
					return 1; //성공
				} else {
					return 0;//아이디 비번 틀려서
				}
			}
			return -1;//아이디 비번 입력해주세요

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(psmt);
			jdbcUtil.close(conn);
		}
		return -2;//DB오류
	}
}
