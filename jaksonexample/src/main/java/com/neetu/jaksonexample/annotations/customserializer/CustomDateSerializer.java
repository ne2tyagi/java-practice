package com.neetu.jaksonexample.annotations.customserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class CustomDateSerializer extends StdSerializer<Date> {
	static final long serialVersionUID = 21212L;
	public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	protected CustomDateSerializer(Class<Date> t) {
		super(t);
	}
	protected CustomDateSerializer() {
		this(null);
	}

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(simpleDateFormat.format(value));
	}

}
