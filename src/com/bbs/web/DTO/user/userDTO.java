package com.bbs.web.DTO.user;

import java.util.Date;

public class userDTO {
	String userID;
	String userPASS;
	String userName;
	String userEmail;
	String userFlag;
	Date regdate;
	
	public userDTO() {
		
	}
	
	public userDTO(String id, String pass, String name, String email) {
		this.userID = id;
		this.userPASS = pass;
		this.userName = name;
		this.userEmail = email;
	}

	@Override
	public String toString() {
		return "userDTO [userID=" + userID + ", userPASS=" + userPASS + ", userName=" + userName + ", userEmail="
				+ userEmail + ", userFlag=" + userFlag + ", regdate=" + regdate + "]";
	}


	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPASS() {
		return userPASS;
	}
	public void setUserPASS(String userPASS) {
		this.userPASS = userPASS;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserFlag() {
		return userFlag;
	}
	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
