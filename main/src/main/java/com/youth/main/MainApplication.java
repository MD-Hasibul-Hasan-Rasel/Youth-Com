package com.youth.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}

/* Notes To Remind
 * Must use name attribute in login feature for spring security automated authentication and login
 * so that it can send data otherwise it will be null.*/
