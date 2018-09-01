package com.neetu.jaksonexample.annotations.getters;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

public class IgnoreTypeDemoBean {
	@JsonIgnoreType
	public static class Address {
		public String pinCode = null;
		public String city = null;
		@Override
		public String toString() {
			return "Address [pinCode=" + pinCode + ", city=" + city + "]";
		}
	}
	public long personId = 0;
	public String name = "James Clark";
	public Address address = new Address();
	@Override
	public String toString() {
		return "IgnoreTypeDemoBean [personId=" + personId + ", name=" + name + ", address=" + address + "]";
	}

}
