package com.springpractice.javaclassconfig.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springpractice.javaclassconfig.demo")
public class ConfigClass {
	@Bean
	public Coach myFootballCoach(FortuneService theFortuneService){
		return new FootballCoach(theFortuneService());
	}
	@Bean
	public FortuneService theFortuneService(){
		return new HappyFortuneService();
	}
}
