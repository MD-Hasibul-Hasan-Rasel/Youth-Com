package com.youth.main.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class PostModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String username;

   private String category;
   
   private String date;

   private String postname;
   
   @Size(min=1, max=10000)
   private String description;
   
   @Column(nullable = true, length = 64)
   private String photos;
   
   public PostModel() {}

   public PostModel(String username, String category, String date, String postname, String description, String photos) {
      this.username = username;
      this.category = category;
      this.date = date;
      this.postname = postname;
      this.description = description;
      this.photos = photos;
   }

   public String getUsername() {
	   return username;
   }

   public void setUsername(String username) {
	   this.username = username;
   }

   public String getDescription() {
	   return description;
   }

   public void setDescription(String description) {
	   this.description = description;
   }

   public String getPhotos() {
	   return photos;
   }

   public void setPhotos(String photos) {
	   this.photos = photos;
   }

   public Long getId() {
	   return id;
   }

   public void setId(Long id) {
	   this.id = id;
   }

   public String getCategory() {
	   return category;
   }	

   public void setCategory(String category) {
	   this.category = category;
   }

   public String getDate() {
	   return date;
   }

   public void setDate(String date) {
	   this.date = date;
   }

   public String getPostname() {
	   return postname;
   }

   public void setPostname(String postname) {
	   this.postname = postname;
   }

   
}