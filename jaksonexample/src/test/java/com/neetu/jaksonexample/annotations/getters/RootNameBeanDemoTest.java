package com.neetu.jaksonexample.annotations.getters;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.neetu.jaksonexample.annotations.getters.RootNameBeanDemo;

public class RootNameBeanDemoTest {
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
		String jsonString = objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE)
				.writeValueAsString(new RootNameBeanDemo());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("user"));
		assertThat(jsonString, containsString("James Clark"));
	}
}
