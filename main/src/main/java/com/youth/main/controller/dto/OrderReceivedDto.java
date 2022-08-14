package com.youth.main.controller.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderReceivedDto {
	
	   private String id;

	   private String otp;

	 private String username;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
