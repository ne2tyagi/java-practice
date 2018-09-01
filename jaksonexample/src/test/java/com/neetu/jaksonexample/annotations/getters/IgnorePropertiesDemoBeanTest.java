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
import com.neetu.jaksonexample.annotations.getters.IgnorePropertiesDemoBean;

public class IgnorePropertiesDemoBeanTest {
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
	public void testSerializationWithIgnoreProperties() throws JsonProcessingException{
		String jsonString = objectMapper.writeValueAsString(new IgnorePropertiesDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("James Clark"));
		assertThat(jsonString, not(containsString("userId")));
		assertThat(jsonString, not(containsString("gender")));
	}
	
	@Test
	public void testDeSerializationWithIgnoreProperties() throws IOException{
		String jsonString = "{\"userId\": 231, \"name\": \"Mary Parker\", \"gender\": \"male\"}";
		IgnorePropertiesDemoBean bean = objectMapper.readValue(jsonString, IgnorePropertiesDemoBean.class);
		
		assertThat(bean.name, is(equalTo("Mary Parker")));
		assertThat(bean.userId, not(equalTo(231L)));
	}
}
