package com.neetu.jaksonexample.annotations.general;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ViewDemoBeanTest {
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
		String jsonString = objectMapper.writerWithView(Views.Public.class).writeValueAsString(new ViewDemoBean());
		String jsonStringWithInternal = objectMapper.writerWithView(Views.Internal.class)
				.writeValueAsString(new ViewDemoBean());
		System.out.println(jsonString);
		System.out.println("internals "+ jsonStringWithInternal);
		assertThat(jsonString, containsString("James Clark"));
		assertThat(jsonString, not(containsString("gender")));
		assertThat(jsonStringWithInternal, containsString("gender"));
	}
}
