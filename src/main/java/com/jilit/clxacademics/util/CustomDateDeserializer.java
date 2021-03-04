package com.jilit.clxacademics.util;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(final JsonParser jsonparser, final DeserializationContext deserializationcontext) throws IOException {
        final String date = jsonparser.getText();

        final long epochMilli = OffsetDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME).toInstant().toEpochMilli();
        return new Date(epochMilli);
    }
}
