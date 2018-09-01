package com.neetu.jaksonexample.annotations.general;


import com.fasterxml.jackson.annotation.JsonView;

public class ViewDemoBean {
	@JsonView(Views.Public.class)
	public long personId = 231L;
	
	public String name = "James Clark";
	
	@JsonView(Views.Internal.class)
	public String gender = "male";

	@Override
	public String toString() {
		return "ViewDemoBean [personId=" + personId + ", name=" + name + ", gender=" + gender + "]";
	}
	
	
}
