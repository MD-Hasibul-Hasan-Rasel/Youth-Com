package com.youth.main.model;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "user", uniqueConstraints = 
       @UniqueConstraint(columnNames = "email"))
public class UserModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

//   @Column(name = "first_name") if column not defined the the field name is taken by database. 
   private String firstName;


   private String lastName;
   
   private String username;

   private String email;

   private String password;
   
   @Column(nullable = true, length = 64)
   private String photos;
   

   @ManyToMany(fetch = FetchType.EAGER, 
                   cascade = CascadeType.ALL)
   @JoinTable(name = "users_roles", 
       joinColumns = @JoinColumn(name = "user_id", 
         referencedColumnName = "id"), 
           inverseJoinColumns = @JoinColumn
              (name = "role_id", 
                 referencedColumnName = "id"))
   private Collection<Role> roles;

   public UserModel() {

   }

   public UserModel(String firstName, String lastName, String username,
		   			String email, String password, String photos, Collection<Role> roles ) {
      
      this.firstName = firstName;
      this.lastName = lastName;
      this.username = username;
      this.email = email;
      this.password = password;
      this.photos = photos;
      this.roles = roles;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
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

   public String getPhotos() {
	return photos;
   }

   public void setPhotos(String photos) {
	this.photos = photos;
   }

   public Collection<Role> getRoles() {
      return roles;
   }

   public void setRoles(Collection<Role> roles) {
      this.roles = roles;
   }

   public String getUsername() {
	   return username;
   }

   public void setUsername(String username) {
	   this.username = username;
   }
}