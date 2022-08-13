package com.youth.main.controller.dto;


import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

	    @Size(min=3, max=15, message="firstname should be between 3 to 15 characters")
	    private String username;

	    private String category;
	   
	    private String postname;
	   
	    private String description;
	   
	    private String photos;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getPostname() {
			return postname;
		}

		public void setPostname(String postname) {
			this.postname = postname;
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
	    
	    
	}