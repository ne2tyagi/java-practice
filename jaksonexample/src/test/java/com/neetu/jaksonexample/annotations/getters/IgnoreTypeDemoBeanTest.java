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
import com.neetu.jaksonexample.annotations.getters.IgnoreTypeDemoBean;

public class IgnoreTypeDemoBeanTest {
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
	public void testSerializationWithIgnoreType() throws JsonProcessingException{
		String jsonString = objectMapper.writeValueAsString(new IgnoreTypeDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, is(containsString("James Clark")));
		assertThat(jsonString, not(containsString("address")));
	}
	@Test
	public void testDeSerializationWithIgnoreType() throws IOException{
		String jsonString = "{\"personId\": 123,\"name\": \"Mary Parker\",\"address\": {\"doorNumber\": \"123\",\"streetName\": \"Phase 1\",\"pincode\": \"123456\",\"city\": \"New York\"}}";
		IgnoreTypeDemoBean bean = objectMapper.readValue(jsonString, IgnoreTypeDemoBean.class);
		System.out.println(bean);
		assertThat(bean.name, is(equalTo("Mary Parker")));
		assertThat(bean.address.city, not(equalTo("New York")));
	}
}
