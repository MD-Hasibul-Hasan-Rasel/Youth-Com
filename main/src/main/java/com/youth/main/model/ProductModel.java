package com.youth.main.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String username;

   private String productno;

   private String productname;
   
   private String price;
   
   private String offer;
   
   @Size(min=1, max=10000)
   private String description;
   
   @Column(nullable = true, length = 64)
   private String photos;
   
   public ProductModel() {}

   public ProductModel(String username, String productno, String productname, String price, String offer, String description, String photos) {
      this.username = username;
      this.productno = productno;
      this.productname = productname;
      this.price = price;
      this.offer = offer;
      this.description = description;
      this.photos = photos;
   }

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getProductno() {
	return productno;
}

public void setProductno(String productno) {
	this.productno = productno;
}

public String getProductname() {
	return productname;
}

public void setProductname(String productname) {
	this.productname = productname;
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

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public String getOffer() {
	return offer;
}

public void setOffer(String offer) {
	this.offer = offer;
}

   
}
