package com.kafka_sample_project.emailservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka_sample_project.emailservice.dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Publisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public Publisher(KafkaTemplate<String, Object> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(String topic, String message) {
//        try {
//            String json = objectMapper.writeValueAsString(dto);
//            System.out.println("josn: " + json);
            kafkaTemplate.send(topic, message);
            log.info("String sent!!");
//        } catch (JsonProcessingException e) {
//            log.error("error happened", e);
//        }
    }
}
