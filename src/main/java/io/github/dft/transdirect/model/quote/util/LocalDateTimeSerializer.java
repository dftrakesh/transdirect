package io.github.dft.transdirect.model.quote.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    private static final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
        .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        .optionalStart()
        .appendOffset("+HHMM", "+0000")
        .optionalEnd()
        .toFormatter();;

    @Override
    @SneakyThrows
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        String formattedDateTime = localDateTime.format(formatter);
        jsonGenerator.writeString(formattedDateTime);
    }
}