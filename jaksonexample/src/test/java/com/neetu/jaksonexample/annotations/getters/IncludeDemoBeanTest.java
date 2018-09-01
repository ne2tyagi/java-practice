package com.neetu.jaksonexample.annotations.getters;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neetu.jaksonexample.annotations.getters.IncludeDemoBean;

public class IncludeDemoBeanTest {
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
		String jsonString = objectMapper.writeValueAsString(new IncludeDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("personId"));
		assertThat(jsonString, not(containsString("name")));
	}
}
