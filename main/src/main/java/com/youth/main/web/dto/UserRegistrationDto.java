package com.youth.main.web.dto;

import javax.validation.constraints.Size;

public class UserRegistrationDto {
		
	   @Size(min=3, max=15, message="firstname should be between 3 to 15 characters")
	   private String firstName;
	   
	   @Size(min=3, max=15, message="lastname should be between 3 to 15 characters")
	   private String lastName;
	   
	   private String username;
	   
	   private String email;
	   
//	   private String phone;
	   @Size(min=5, max=8, message="password should be between 5 to 8 characters")
	   private String password;
	   
	   private String retypepassword;
	   
	   private String photo;

	   public UserRegistrationDto() {

	   }

	   public String getFirstName() {
	      return firstName;
	   }

	   public void setFirstName(String firstName) {
	      this.firstName = firstName;
	   }

	   public String getLastName() {
	      return lastName;
	   }

	   public void setLastName(String lastName) {
	      this.lastName = lastName;
	   }

	   public String getEmail() {
	      return email;
	   }

	   public void setEmail(String email) {
	      this.email = email;
	   }

	   public String getPassword() {
	      return password;
	   }

	   public void setPassword(String password) {
	      this.password = password;
	   }

	public String getRetypepassword() {
		return retypepassword;
	}

	public void setRetypepassword(String retypepassword) {
		this.retypepassword = retypepassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	  
}






















