package com.neetu.jaksonexample.annotations.getters;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"personName","personId"})
public class PropertyOrderDemoBean {
	public long personId = 231L;
	public String personName = "James Clark";
	@Override
	public String toString() {
		return "PropertyOrderDemoBean [personId=" + personId + ", personName=" + personName + "]";
	}
	
}
