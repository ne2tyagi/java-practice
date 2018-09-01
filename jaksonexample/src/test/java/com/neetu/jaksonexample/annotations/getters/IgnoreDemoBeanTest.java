package com.neetu.jaksonexample.annotations.getters;

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
import com.neetu.jaksonexample.annotations.getters.IgnoreDemoBean;

public class IgnoreDemoBeanTest {
	private ObjectMapper objectMapper;
	@Before
	public void setUp() throws Exception {
		objectMapper = new ObjectMapper();
	}
	@After
	public void tearDown() throws Exception{
		objectMapper = null;
	}

	@Test
	public void testSerializationWithJsonIgnore() throws JsonProcessingException{
		String jsonString = objectMapper.writeValueAsString(new IgnoreDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("James Clark"));
		assertThat(jsonString, not(containsString("personId")));
	}
	
	@Test
	public void testDeSerializationWithJsonIgnore() throws IOException{
		String jsonString = "{\"name\":\"James Clark new\",\"personId\":231}";
		IgnoreDemoBean obj = objectMapper.readValue(jsonString, IgnoreDemoBean.class);
		System.out.println(obj);
		assertThat(obj.getName(), is(equalTo("James Clark new")));
		assertThat(obj.getPersonId(), not(equalTo(231L)));
	}
}
