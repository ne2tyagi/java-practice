package com.neetu.jaksonexample.annotations.getters;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class IgnoreDemoBean{
	@JsonIgnore
	private long personId = 0;
	private String name = "James Clark";
	@Override
	public String toString() {
		return "IgnoreDemoBean [personId=" + personId + ", name=" + name + "]";
	}
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
	
}