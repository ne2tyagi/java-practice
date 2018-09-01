package com.neetu.jaksonexample.annotations.setters;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatorDemoBean {
	public long personId = 0;
	public String personName = "James Clark";
	@JsonCreator
	public CreatorDemoBean(@JsonProperty("id") long personId, @JsonProperty("name") String personName) {
		this.personId = personId;
		this.personName = personName;
	}
	@Override
	public String toString() {
		return "CreatorDemoBean [personId=" + personId + ", personName=" + personName + "]";
	}
	
}
