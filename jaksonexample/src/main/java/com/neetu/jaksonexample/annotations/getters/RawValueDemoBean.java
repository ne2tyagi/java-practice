package com.neetu.jaksonexample.annotations.getters;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class RawValueDemoBean {
	public long personId = 231L;
	public String personName = "James Clark";
	
	@JsonRawValue
	public String address = "{\"doorNumber\": 1234, \"street\": \"phase-1\", " +
            "\"city\": \"New York\"}";
}
