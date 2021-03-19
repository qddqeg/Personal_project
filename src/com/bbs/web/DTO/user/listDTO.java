package com.bbs.web.DTO.user;

import java.util.Date;

public class listDTO {
	int id;
	String title;
	String writerId;
	String content;
	Date regDate;
	int hit;
	String files;
	boolean pub;
	
	//생성자
	public listDTO() {
		
	}
	
	//생성자 오버라이드
	public listDTO(int id, String title, String writerId, String content, Date regDate, int hit, String files,
			boolean pub) {
		
		this.id = id;
		this.title = title;
		this.writerId = writerId;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
		this.files = files;
		this.pub = pub;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public boolean getPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
	}
}
