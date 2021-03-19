package com.bbs.web.DTO.user;

import java.util.Date;

public class imgDTO {
private	String pid;
private	String pname;
private	String content;
private	String category;
private	int price;
private	Date regdate;
private	String delFlag;
private	String path;



public imgDTO(String pid, String pname, String content, String category, int price, Date regdate, String delFlag,
		String path) {
	this.pid = pid;
	this.pname = pname;
	this.content = content;
	this.category = category;
	this.price = price;
	this.regdate = regdate;
	this.delFlag = delFlag;
	this.path = path;
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}
public String getDelFlag() {
	return delFlag;
}
public void setDelFlag(String delFlag) {
	this.delFlag = delFlag;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
}
