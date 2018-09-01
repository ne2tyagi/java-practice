package com.neetu.jaksonexample.annotations.managedreference;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BackReferenceDemoBeanTest {
	private ObjectMapper objectMapper;

	@Before
	public void setUp() throws Exception {
		objectMapper = new ObjectMapper();
	}

	@After
	public void tearDown() throws Exception {
		objectMapper = null;
	}

	@Test
	public void testSerialization() throws JsonProcessingException {
		BackReferenceDemoBean manager = new BackReferenceDemoBean(23L, "James");

		ManagedReferenceDemoBean empBean = new ManagedReferenceDemoBean(230L, "Carl", manager);
		manager.addEmployee(empBean);
		String jsonString = objectMapper.writeValueAsString(empBean);
		System.out.println(jsonString);
		assertThat(jsonString, containsString("manager"));
	}
}
