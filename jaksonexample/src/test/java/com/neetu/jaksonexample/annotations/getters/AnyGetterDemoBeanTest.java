package com.neetu.jaksonexample.annotations.getters;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neetu.jaksonexample.annotations.getters.AnyGetterDemoBean;

public class AnyGetterDemoBeanTest {
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
		AnyGetterDemoBean bean =new AnyGetterDemoBean();
		Map<String, String> stringMap = bean.getProperties();
		stringMap.put("email", "james.clark@yahoo.com");
		stringMap.put("gender", "male");
		String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean);
		System.out.println(jsonString);
		assertThat(jsonString, containsString("email"));
		assertThat(jsonString, containsString("gender"));
	}
}
