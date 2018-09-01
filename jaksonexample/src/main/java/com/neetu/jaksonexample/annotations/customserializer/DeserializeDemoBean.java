package com.neetu.jaksonexample.annotations.customserializer;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class DeserializeDemoBean {
	public long personId = 0;
	public String personName = "James Clark";
	@JsonDeserialize(using = CustomDateDeSerializer.class)
	public Date activeDate;
	@Override
	public String toString() {
		return "DeserializeDemoBean [personId=" + personId + ", personName=" + personName + ", activeDate=" + activeDate
				+ "]";
	}
}
