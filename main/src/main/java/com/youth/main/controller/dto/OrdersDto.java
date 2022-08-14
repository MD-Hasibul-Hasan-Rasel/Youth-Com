package com.youth.main.controller.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDto {
	
	    private String quantity;
	   
	    private String useraddress;
	    
	    private String productname;

		public String getQuantity() {
			return quantity;
		}

		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}

		public String getUseraddress() {
			return useraddress;
		}

		public void setUseraddress(String useraddress) {
			this.useraddress = useraddress;
		}

		public String getProductname() {
			return productname;
		}

		public void setProductname(String productname) {
			this.productname = productname;
		}

		
	   
	    
	    
	    
	}