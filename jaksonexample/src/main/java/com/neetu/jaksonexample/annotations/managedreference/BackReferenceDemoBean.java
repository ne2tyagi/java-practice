package com.neetu.jaksonexample.annotations.managedreference;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class BackReferenceDemoBean {
	public long personId = 0;
	public String name = "John";
	
	@JsonBackReference
	public List<ManagedReferenceDemoBean> employees;

	public BackReferenceDemoBean(long personId, String name) {
		this.personId = personId;
		this.name = name;
		employees = new ArrayList<ManagedReferenceDemoBean>();
	}
	public void addEmployee(ManagedReferenceDemoBean emp){
		employees.add(emp);
	}
	
}
