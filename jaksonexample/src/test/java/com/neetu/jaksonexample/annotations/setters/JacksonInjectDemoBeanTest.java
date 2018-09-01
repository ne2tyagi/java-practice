package com.neetu.jaksonexample.annotations.setters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonInjectDemoBeanTest {
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
		String jsonString = "{\"personName\": \"Mary Parker\"}";
		InjectableValues injectableValues = new InjectableValues.Std().addValue(long.class, 231L);
		JacksonInjectDemoBean bean = objectMapper.reader(injectableValues).forType(JacksonInjectDemoBean.class)
				.readValue(jsonString);
		System.out.println(bean);
		assertThat(bean.personId, is(equalTo(231L)));
		assertThat(bean.personName, is(equalTo("Mary Parker")));
	}
}
