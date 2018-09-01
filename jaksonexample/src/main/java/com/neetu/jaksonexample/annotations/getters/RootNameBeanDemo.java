package com.neetu.jaksonexample.annotations.getters;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user")
public class RootNameBeanDemo {
	public long personId = 231L;
	public String personName = "James Clark";
	@Override
	public String toString() {
		return "RootNameBeanDemo [personId=" + personId + ", personName=" + personName + "]";
	}
	
}
