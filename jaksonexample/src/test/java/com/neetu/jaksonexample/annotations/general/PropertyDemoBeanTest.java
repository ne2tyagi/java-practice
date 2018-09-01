package com.neetu.jaksonexample.annotations.general;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertyDemoBeanTest {
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
		String jsonString = objectMapper.writeValueAsString(new PropertyDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("person-id"));
		assertThat(jsonString, containsString("person-name"));
	}
	
	@Test
	public void testDeSerialization() throws IOException {
		String jsonString = "{\"person-id\": 231, \"person-name\": \"Mary Parker\"}";
		PropertyDemoBean bean = objectMapper.readValue(jsonString, PropertyDemoBean.class);
		System.out.println(bean);
		assertThat(bean.personId, is(equalTo(231L)));
		assertThat(bean.name, is(equalTo("Mary Parker")));
	}
}


