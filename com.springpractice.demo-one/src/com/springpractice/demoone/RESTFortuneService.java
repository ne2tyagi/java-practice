package com.springpractice.demoone;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "From Rest fortune service "+(new java.util.Random().nextInt(5));
	}

}
