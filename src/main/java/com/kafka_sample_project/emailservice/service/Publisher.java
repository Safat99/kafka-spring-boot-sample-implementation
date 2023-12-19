package com.kafka_sample_project.emailservice.service;

import com.kafka_sample_project.emailservice.config.KafkaTopicConfig;
import com.kafka_sample_project.emailservice.dto.TestDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Publisher {

    private KafkaTopicConfig kafkaTopicConfig;
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void SendMessage(String topic, TestDto dto){
        kafkaTemplate.send(topic, dto);
    }
}
