package com.youth.main.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security
    .authentication.dao.DaoAuthenticationProvider;
import org.springframework.security
    .config.annotation.authentication
        .builders.AuthenticationManagerBuilder;
import org.springframework.security
    .config.annotation.web.builders.HttpSecurity;
import org.springframework.security
    .config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security
    .config.annotation.web.configuration
      .WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security
    .crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.util.UrlPathHelper;

@Configuration
@EnableWebSecurity
public class UserConfiguration 
            extends WebSecurityConfigurerAdapter {

   @Bean
   public UserDetailsService userDetailsService() {
       return new UserServiceConfig();
   }

   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Bean
   public DaoAuthenticationProvider daoAuthenticationProvider() {
      
      DaoAuthenticationProvider auth = 
            new DaoAuthenticationProvider();
      auth.setUserDetailsService(userDetailsService());
      auth.setPasswordEncoder(passwordEncoder());
      return auth;
   }

    @Override
   protected void configure(AuthenticationManagerBuilder auth) 
          throws Exception {
      
      auth.authenticationProvider(daoAuthenticationProvider());
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
	   
	   http.
        authorizeRequests()
            .antMatchers("/css/**", "/js/**", "/images/**", "/svg/**", "/uploads/**").permitAll()
            .antMatchers("/index").permitAll()
            .antMatchers("/searchpage").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/registration").permitAll()
            .antMatchers("/user/**").hasAuthority("USER")
            .antMatchers("/admin/**").hasAuthority("ADMIN")
            .antMatchers("/seller/**").hasAuthority("SELLER")
            .anyRequest()
            .authenticated().and()
            .formLogin()
            .loginPage("/login")
			.loginProcessingUrl("/do_login")
			.failureUrl("/login?error=true")
            .defaultSuccessUrl("/index")
            .usernameParameter("username")
            .passwordParameter("password")
            .and().logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login").and().exceptionHandling()
            .accessDeniedPage("/access-denied");
      
	   
           /*.failureHandler(new AuthenticationFailureHandler() {
        	   
        	   @Override
        	   public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
        			   AuthenticationException exception) throws IOException, ServletException {
        		   
        		   System.out.println("login failed, error : "+exception.getLocalizedMessage());
        		   
        		   UrlPathHelper urlPathHelper = new UrlPathHelper();
        		   response.sendRedirect("/user_login?errorccurence");
        		   
        	   }
        	   
           })*/
	   	   
	   
	   
	   
      
      

   }
}











