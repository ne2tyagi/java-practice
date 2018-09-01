package com.neetu.jaksonexample.annotations.setters;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neetu.jaksonexample.annotations.setters.SetterDemoBean;

public class SetterDemoBeanTest {
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
	public void testDeSerialization() throws IOException {
		String jsonString = "{\"id\": 231, \"personName\": \"Mary Parker\"}";
		SetterDemoBean bean = objectMapper.readValue(jsonString, SetterDemoBean.class);
		System.out.println(bean);
		assertThat(bean.personId, is(equalTo(231L)));
		assertThat(bean.personName, is(equalTo("Mary Parker")));
	}
}
