package com.youth.main.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetails;

import com.youth.main.model.UserModel;
import com.youth.main.model.Role;


public class UserDetailsC implements UserDetails {
 
    private UserModel user;
     
//    public UserDetailsC(UserModel user) {
//        this.user = user;
//    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    	for(Role role:user.getRoles()) {
    		authorities.add(new SimpleGrantedAuthority(role.getName()));
    	}
    	
    	return authorities;
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getUsername();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
     
//    public String getFullName() {
//        return user.getFirstName() + " " + user.getLastName();
//    }
 
}
