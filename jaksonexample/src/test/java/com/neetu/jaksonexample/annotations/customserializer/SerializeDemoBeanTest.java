package com.neetu.jaksonexample.annotations.customserializer;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeDemoBeanTest {
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
	public void testSerialization() throws JsonProcessingException, ParseException {
		SerializeDemoBean bean = new SerializeDemoBean();
		Date activeDate = CustomDateSerializer.simpleDateFormat.parse("25-10-2018 12:20:45");
		bean.setActiveDate(activeDate);
		String jsonString = objectMapper.writeValueAsString(bean);
		System.out.println(jsonString);
		assertThat(jsonString, containsString("25-10-2018 12:20:45"));
		assertThat(jsonString, containsString("James Clark"));
	}
}
