package com.kafka_sample_project.emailservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TestDto {

    private String message;
    private String topic;

    @Override
    public String toString() {
        return "TestDto{" +
                "topic='" + topic + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


}
