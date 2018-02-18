package com.springpractice.javaclassconfig.demo;

import org.springframework.stereotype.Component;

@Component("myCoach")
public class TrackCoach implements Coach {
	private FortuneService happyFortuneService;
	TrackCoach(FortuneService happyFortuneService) {
		this.happyFortuneService = happyFortuneService;
	}
	public String getDailyRoutine(){
		return "Practice Hard run 10km";
	}
	public String getDailyFortune(){
		return happyFortuneService.getDailyFortune();
	}
}
