package com.jilit.clxacademics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan; 
/*
 * Spring boot starter Class
 * By Ashok
  */
 

@SpringBootApplication
//@EnableWebSecurity



@ComponentScan(value = "com.jilit.clxacademics")
//@ComponentScan(value = "com.jilit.clxacademics.repository")
public class Application extends SpringBootServletInitializer 
{
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Application.class);
	    }
	 
	
 public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    }
