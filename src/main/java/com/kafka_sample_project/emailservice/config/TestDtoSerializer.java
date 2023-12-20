package com.kafka_sample_project.emailservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka_sample_project.emailservice.dto.TestDto;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class TestDtoSerializer implements Serializer<TestDto> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No additional configuration needed
    }

    @Override
    public byte[] serialize(String topic, TestDto data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error serializing TestDto", e);
        }
    }

    @Override
    public void close() {
        // No resources to close
        // good practice to keep them for future implementations
    }
}
