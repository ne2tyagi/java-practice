package com.neetu.jaksonexample.annotations.setters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AnySetterDemoBeanTest {
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
	public void testSerialization() throws IOException {
		String jsonString = "{\"personId\": 231, \"personName\": \"Mary Parker\", \"emailId\": \"mary@gmail.com\", \"gender\": \"female\"}";
		AnySetterDemoBean bean = objectMapper.readValue(jsonString, AnySetterDemoBean.class);
		System.out.println(bean);
		assertThat(bean.personId, is(equalTo(231L)));
		assertThat(bean.getProperties().get("emailId"), is(equalTo("mary@gmail.com")));
	}
}
