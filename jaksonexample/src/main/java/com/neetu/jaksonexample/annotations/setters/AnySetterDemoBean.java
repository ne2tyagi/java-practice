package com.neetu.jaksonexample.annotations.setters;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class AnySetterDemoBean {
	public long personId = 231L;
	public String personName = "James Clark";
	
	private Map<String, String> properties = new HashMap<String, String>();
	
	@JsonAnySetter
	public void setProperties(String key, String value){
		properties.put(key,  value);
	}

	@Override
	public String toString() {
		return "AnySetterDemoBean [personId=" + personId + ", personName=" + personName + ", properties=" + properties
				+ "]";
	}

	public Map<String, String> getProperties() {
		return properties;
	}
}
