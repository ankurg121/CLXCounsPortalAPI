package com.jilit.clxacademics.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustomDateSerializer extends JsonSerializer<Date> {

    static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static {
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public void serialize(final Date value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeString(format.format(value));
    }
}
