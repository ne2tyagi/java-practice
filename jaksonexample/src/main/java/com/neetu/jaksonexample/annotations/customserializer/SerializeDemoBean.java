package com.neetu.jaksonexample.annotations.customserializer;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class SerializeDemoBean {
	public long personId = 231L;
	public String name = "James Clark";
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date activeDate;
	
	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}
}
