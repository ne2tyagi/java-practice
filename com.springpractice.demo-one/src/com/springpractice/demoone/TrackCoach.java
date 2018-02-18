package com.springpractice.demoone;

public class TrackCoach implements Coach {

	private FortuneService myHappyFortuneService;
	TrackCoach(FortuneService maFortuneService){
		myHappyFortuneService = maFortuneService;
	}
	@Override
	public String getDailyRoutine() {
		return "Run hard 10km";
	}

	@Override
	public String getDailyFortune(){
		return myHappyFortuneService.getDailyFortune();
	}
	
	public void startupFunc(){
		System.out.println("initialing the bean");
	}
	public void cleanUpFunc(){
		System.out.println("Clean up");
	}
}
