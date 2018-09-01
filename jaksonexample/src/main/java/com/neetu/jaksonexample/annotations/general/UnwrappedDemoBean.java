package com.neetu.jaksonexample.annotations.general;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class UnwrappedDemoBean {
	public long personId = 0;
	public String name = "James Clark";
	public static class Address{
		public String pinCode = "110021";
		public String city = "New Delhi";
		@Override
		public String toString() {
			return "Address [pinCode=" + pinCode + ", city=" + city + "]";
		}
		
	}
	@JsonUnwrapped
	public Address address = new Address();
	
}
