package com.neetu.jaksonexample.annotations.customserializer;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializeDemoBeanTest {
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
	public void testDeSerialization() throws IOException, ParseException {
		String jsonString = "{\"personId\": 231, \"personName\": \"Mary Parker\", " +
          "\"activeDate\":\"26-09-2017 11:00:00\"}";
		DeserializeDemoBean bean = objectMapper.readValue(jsonString, DeserializeDemoBean.class);
		System.out.println(bean);
		assertThat(bean.activeDate, is(equalTo(CustomDateDeSerializer.simpleDateFormat.parse("26-09-2017 11:00:00"))));
		assertThat(bean.personName, is(equalTo("Mary Parker")));
	}
}
