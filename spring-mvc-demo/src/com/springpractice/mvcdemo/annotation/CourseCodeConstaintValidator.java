package com.springpractice.mvcdemo.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstaintValidator
	implements ConstraintValidator<CourseCode, String>{
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCode){
		coursePrefix = theCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext arg1) {
		boolean result = theCode!=null ? theCode.startsWith(coursePrefix) : false;
		return result;
	}

}
