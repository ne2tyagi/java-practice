package com.neetu.jaksonexample.annotations.customserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomDateDeSerializer extends StdDeserializer<Date>{

	private static final long serialVersionUID = 1L;
	public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	protected CustomDateDeSerializer() {
		this(null);
	}
	protected CustomDateDeSerializer(Class<Date> vc) {
		super(vc);
	}

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		try {
			return simpleDateFormat.parse(p.getText());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
