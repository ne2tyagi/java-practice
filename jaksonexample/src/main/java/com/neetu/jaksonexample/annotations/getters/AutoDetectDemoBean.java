package com.neetu.jaksonexample.annotations.getters;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AutoDetectDemoBean {
	public long personId = 231L;
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
	@Override
	public String toString() {
		return "AutoDetectDemoBean [personId=" + personId + ", name=" + name + "]";
	}

}
