package com.nebula.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public AppSecurity createInstance()
	{
		AppSecurity as=new AppSecurity();
		//custom logic for secure our functionality
		return as;
	}

}
