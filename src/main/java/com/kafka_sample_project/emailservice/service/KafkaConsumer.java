package com.kafka_sample_project.emailservice.service;

import com.kafka_sample_project.emailservice.constant.ApplicationConstant;
import com.kafka_sample_project.emailservice.dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = ApplicationConstant.MAIL_TOPIC, groupId = ApplicationConstant.GROUP_ID_STRING)
    public void listen(String message) {
        log.info("Received the following message:" + message);
    }

    @KafkaListener(topics = ApplicationConstant.MAIL_TOPIC_OBJECT, groupId = ApplicationConstant.GROUP_ID_OBJECT, containerFactory = "kafkaListenerJsonContainerFactory")
    public void listenObject(TestDto dto) {
        log.info("<<<<<<<<<<<< object received from kafka invoked!! \n");
        log.info("Received the following object:" +  dto);
    }
}
