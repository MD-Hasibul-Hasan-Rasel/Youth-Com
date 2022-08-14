package com.youth.main.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class CommentModel {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;

	   private String username;

	   private String postname;
	   
	   private String date;
	   
	   @Size(min=1, max=10000)
	   private String comment;

	public CommentModel(String username, String postname, String date, @Size(min = 1, max = 10000) String comment) {
		super();
		this.username = username;
		this.postname = postname;
		this.date = date;
		this.comment = comment;
	}

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
