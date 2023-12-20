package com.kafka_sample_project.emailservice.service;

import com.kafka_sample_project.emailservice.dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Publisher {

    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final KafkaTemplate<String, TestDto> jsonKafkaTemplate;

    public Publisher(KafkaTemplate<String, String> stringKafkaTemplate, KafkaTemplate<String, TestDto> jsonKafkaTemplate) {
        this.stringKafkaTemplate = stringKafkaTemplate;
        this.jsonKafkaTemplate = jsonKafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        stringKafkaTemplate.send(topic, message);
        log.info("String sent!!");
    }

    public void sendObject(String topic, TestDto testDto) {
        log.info("Sending JSON: =======>>>>>>>\n" + testDto.toString());

        /*
        ==> using message builder we can send message to kafka.This approach also works pretty well.

        Message<TestDto> message = MessageBuilder
                .withPayload(testDto)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        jsonKafkaTemplate.send(message);
        */
        jsonKafkaTemplate.send(topic, testDto);

        log.info("JSON sent!!");
    }
}
