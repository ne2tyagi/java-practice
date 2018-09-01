package com.neetu.jaksonexample.annotations.getters;

import com.fasterxml.jackson.annotation.JsonGetter;

public class GetterDemoBean {
	private long personId = 231L;
	private String name = "James Clark";
	
	@JsonGetter(value = "person-id")
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	@JsonGetter(value = "person-name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "GetterDemoBean [personId=" + personId + ", name=" + name + "]";
	}
}
