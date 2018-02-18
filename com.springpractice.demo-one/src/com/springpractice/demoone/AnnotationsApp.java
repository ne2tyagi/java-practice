package com.springpractice.demoone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new
				ClassPathXmlApplicationContext("annotConfig.xml");
		Coach myFootballCoach = context.getBean("footballCoach", Coach.class);
		System.out.println(myFootballCoach.getDailyFortune());
		context.close();
	}

}
