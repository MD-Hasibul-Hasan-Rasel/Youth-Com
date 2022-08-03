package com.youth.main.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

//   @Lazy
//   @Autowired
//   private UserService userService;
   
//   @Autowired
//   private DataSource dataSource;
    
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
	   
	   http.authorizeRequests()
	   .antMatchers("/*",
			   "/user_registration**", "/css/**", "/js/**", "/images/**")
	   .permitAll()
	   .antMatchers("/user/**")
	   .hasAuthority("USER")
	   .and()
	   .formLogin()
	   .loginPage("/user_login")
	   .loginProcessingUrl("/do-login")
	   .defaultSuccessUrl("/index")
//	   .defaultSuccessUrl("/user_login")
	   .permitAll()
	   .and()
	   .logout()
	   .invalidateHttpSession(true)
	   .clearAuthentication(true)
	   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	   .logoutSuccessUrl("/user_login?logout")
	   .permitAll();
      
	   /*http.authorizeRequests()
	   	   .antMatchers("/user/**")
	   	   .hasRole("USER")
	   	   .antMatchers("/**")
	   	   .permitAll()
	   	   .and()
	   	   .formLogin()
           .failureHandler(new AuthenticationFailureHandler() {
        	   
        	   @Override
        	   public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
        			   AuthenticationException exception) throws IOException, ServletException {
        		   
        		   System.out.println("login failed, error : "+exception.getLocalizedMessage());
        		   
        		   UrlPathHelper urlPathHelper = new UrlPathHelper();
        		   response.sendRedirect("/user_login?errorccurence");
        		   
        	   }
        	   
           })
	   	   .loginPage("/user_login")
	   	   .loginProcessingUrl("/dologin")
	   	   .defaultSuccessUrl("/")
	   	   .and()
	   	   .csrf()
	   	   .disable();*/
	   
	   
	   
      
      

   }
}











