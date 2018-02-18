package com.springpractice.demoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {
	private FortuneService myFortuneService;
	@Autowired
	
	FootballCoach(@Qualifier("RESTFortuneService")FortuneService theService){
		System.out.println("in default const");
		myFortuneService = theService;
	}
	@Override
	public String getDailyRoutine() {
		return "Practice daily";
	}

	@Override
	public String getDailyFortune() {
		return myFortuneService.getDailyFortune();
	}

}
