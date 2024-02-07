package com.nebula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.nebula.security.AppSecurity;

@SpringBootApplication
@ComponentScan(basePackages = {"com.nebula","com.wallmart"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
  
	
}
