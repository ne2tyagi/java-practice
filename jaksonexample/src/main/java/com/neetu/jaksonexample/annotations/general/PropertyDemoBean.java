package com.neetu.jaksonexample.annotations.general;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PropertyDemoBean {
	@JsonProperty("person-id")
	public long personId = 0;
	@JsonProperty("person-name")
	public String name = "James Clark";
	@Override
	public String toString() {
		return "PropertyDemoBean [personId=" + personId + ", name=" + name + "]";
	}
	
}
