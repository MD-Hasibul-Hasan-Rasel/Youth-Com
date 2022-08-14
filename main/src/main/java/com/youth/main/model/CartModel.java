package com.youth.main.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@Entity
@Table(name = "carts")
public class CartModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;

	private String productname;
	
	private String sellername;
	
	private String photos;
	
	private String productno;

	public CartModel() {};
	
	public CartModel(String username, String productno, String productname, String sellername, String photos) {
		super();
		this.username = username;
		this.productname = productname;
		this.sellername = sellername;
		this.photos = photos;
		this.productno = productno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getProductno() {
		return productno;
	}

	public void setProductno(String productno) {
		this.productno = productno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
