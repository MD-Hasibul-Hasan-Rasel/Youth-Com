package com.youth.main.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfiguration implements WebMvcConfigurer{

	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		Path imgUploadDir = Paths.get("./uploads");
		String imgUploadpath = imgUploadDir.toFile().getAbsolutePath();
		
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:/"+imgUploadpath);
	}
}
