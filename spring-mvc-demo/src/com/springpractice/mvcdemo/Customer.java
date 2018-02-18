package com.springpractice.mvcdemo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.springpractice.mvcdemo.annotation.CourseCode;

public class Customer {
	@NotNull(message="is required")
	@Size(min=1, message="must has at least 1 character")
	private String firstName;
	private String lastName;
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="not a valid postal code")
	private String postalCode;
	@Min(value=0, message="should be 0 or more")
	@Max(value=5, message="max 5 free passes")
	private int freePasses;
	@CourseCode(value="Tops", message="Course Name should start with Tops")
	private String courseCode;
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
}
