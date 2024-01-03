package com.example.EmployeeManagement.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    private final String TOPIC_NAME = "firstTopic";

    @Bean
    public NewTopic firstTopic(){
       return TopicBuilder.name(TOPIC_NAME).build();
    }
}
