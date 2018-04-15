package com.sample.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.sample.demo")
public class SpringMvcConfig {

	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewRes = new InternalResourceViewResolver();
		viewRes.setPrefix("/WEB-INF/view/");
		viewRes.setSuffix(".jsp");
		return viewRes;
	}
}
