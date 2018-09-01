package com.neetu.jaksonexample.annotations.setters;

import com.fasterxml.jackson.annotation.JacksonInject;

public class JacksonInjectDemoBean {
	@JacksonInject
	public long personId = 0;
	public String personName = "James Clark";
	@Override
	public String toString() {
		return "JacksonInjectDemoBean [personId=" + personId + ", personName=" + personName + "]";
	}
	
}
