package com.youth.main.controller.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
	
	   private String username;

	   private String postname;
	   
	   private String date;
	   
	   private String comment;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	   
	   

}
