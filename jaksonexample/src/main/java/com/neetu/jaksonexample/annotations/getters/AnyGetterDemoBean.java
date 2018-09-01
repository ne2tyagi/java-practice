package com.neetu.jaksonexample.annotations.getters;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class AnyGetterDemoBean {
	public long personId = 231L;
	public String personName = "James Clark";
	
	private Map<String, String> properties = new HashMap<String, String>();
	
	@JsonAnyGetter
	public Map<String, String> getProperties(){
		return properties;
	}
}
