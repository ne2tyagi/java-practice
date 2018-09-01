package com.neetu.jaksonexample.annotations.general;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FormatDemoBean {
	public long personId = 231L;
	public String personName = "James Clark";
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
	@JsonProperty("active-date")
	public Date activeDate;

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}
	
}
