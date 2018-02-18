package com.springpractice.demoone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
		Coach myCoach  = context.getBean("myCoach", Coach.class);
		
		String routine = myCoach.getDailyRoutine();
		System.out.println(routine);
		
		String dailyFortune = myCoach.getDailyFortune();
		System.out.println(dailyFortune);
		
		context.close();
	}

}
