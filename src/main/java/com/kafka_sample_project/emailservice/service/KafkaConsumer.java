package com.kafka_sample_project.emailservice.service;

import com.kafka_sample_project.emailservice.dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    public void listen(TestDto dto) {
        log.info("Received the following dto: " + dto.toString());
    }
}
