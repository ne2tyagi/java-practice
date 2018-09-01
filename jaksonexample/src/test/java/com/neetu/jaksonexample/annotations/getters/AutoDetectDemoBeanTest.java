package com.neetu.jaksonexample.annotations.getters;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neetu.jaksonexample.annotations.getters.AutoDetectDemoBean;

public class AutoDetectDemoBeanTest {
	private ObjectMapper objectMapper;
	
	@Before
	public void setUp(){
		objectMapper = new ObjectMapper();
	}
	@After
	public void tearDown(){
		objectMapper = null;
	}
	
	@Test
	public void testSerializationAutoDetect() throws JsonProcessingException{
		String jsonString = objectMapper.writeValueAsString(new AutoDetectDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("James Clark"));
		assertThat(jsonString, containsString("231"));
	}
}
