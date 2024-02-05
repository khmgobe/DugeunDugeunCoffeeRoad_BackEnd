package com.easycoffee.backend.common.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import lombok.SneakyThrows;

import java.util.List;

public class ListConverter implements AttributeConverter<List<String>, String> {

    private static final ObjectMapper mapper = new ObjectMapper().
            configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false).
            configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);

    @SneakyThrows
    public String convertToDatabaseColumn(List<String> attribute) {
            return mapper.writeValueAsString(attribute);
    }

    @SneakyThrows
    public List<String> convertToEntityAttribute(String dbData) {
            return mapper.readValue(dbData, List.class);
    }
}
