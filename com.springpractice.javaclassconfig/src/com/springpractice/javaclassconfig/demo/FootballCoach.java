package com.springpractice.javaclassconfig.demo;

public class FootballCoach implements Coach {
	private FortuneService happyFortuneService;
	FootballCoach(FortuneService theFortuneService){
		happyFortuneService = theFortuneService;
	}
	@Override
	public String getDailyRoutine() {
		
		return "Practice Goalkeeping for 4hrs.";
	}

	@Override
	public String getDailyFortune() {
		return happyFortuneService.getDailyFortune();
	}

}
