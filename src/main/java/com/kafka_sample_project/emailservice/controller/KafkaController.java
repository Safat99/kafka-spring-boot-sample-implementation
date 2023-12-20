package com.kafka_sample_project.emailservice.controller;

import com.kafka_sample_project.emailservice.constant.ApplicationConstant;
import com.kafka_sample_project.emailservice.dto.TestDto;
import com.kafka_sample_project.emailservice.service.Publisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final Publisher messagePublisher;

    public KafkaController(Publisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody TestDto testDto) {
        messagePublisher.sendMessage(ApplicationConstant.MAIL_TOPIC, testDto.getMessage());
        return ResponseEntity.ok("Message sent!!");
    }

    @PostMapping("/send-object")
    public ResponseEntity<String> sendObject(@RequestBody TestDto testDto) {
        messagePublisher.sendObject(ApplicationConstant.MAIL_TOPIC_OBJECT, testDto);
        return ResponseEntity.ok("Object sent!!");
    }

}
