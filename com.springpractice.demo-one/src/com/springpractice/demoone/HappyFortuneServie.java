package com.springpractice.demoone;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneServie implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "This is your lucky day.";
	}

}
