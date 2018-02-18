package com.springpractice.javaclassconfig.demo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		
		return "This is your lucky day.";
	}

}
