package com.springpractice.javaclassconfig.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		Coach myCoach = context.getBean("myCoach", Coach.class);
		System.out.println(myCoach.getDailyRoutine());
		System.out.println(myCoach.getDailyFortune());
		
		Coach myFootballCoach = context.getBean("myFootballCoach", Coach.class);
		System.out.println(myFootballCoach.getDailyFortune());
		context.close();
	}

}
