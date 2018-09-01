package com.neetu.jaksonexample.annotations.getters;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class ValueDemoBean {
	@JsonProperty
	private long personId = 231L;
	
	@JsonProperty
	private String name = "James Clark";
	
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonValue
	public String toJson(){
		return this.name +", "+this.personId +", "+this.toString();
	}
	@Override
	public String toString() {
		return "ValueDemoBean [personId=" + personId + ", name=" + name + "]";
	}
}
