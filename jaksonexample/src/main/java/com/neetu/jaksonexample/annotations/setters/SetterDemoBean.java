package com.neetu.jaksonexample.annotations.setters;

import com.fasterxml.jackson.annotation.JsonSetter;

public class SetterDemoBean {
	public long personId = 231L;
	public String personName = "James Clark";
	@JsonSetter(value = "id")
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	@Override
	public String toString() {
		return "SetterDemoBean [personId=" + personId + ", personName=" + personName + "]";
	}
	
}
