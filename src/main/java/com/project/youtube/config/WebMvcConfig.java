package com.project.youtube.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	 public void addCorsMapping(CorsRegistry registry) {
		registry.addMapping("/**");
				 
	}
}
