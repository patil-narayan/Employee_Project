package com.example.EmployeeManagement.configuration;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("localhost:9092")
    private String bootStrap_Server;

    //Kafka Producer Configuration
    public Map<String,Object> producerConfig() {
         Map<String, Object> stringObjectMap = new HashMap<>();
         stringObjectMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrap_Server);
         stringObjectMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
         stringObjectMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
         return stringObjectMap;

       }
        //to create Producer Instance Or TO create Bean of Producer
        @Bean
        public ProducerFactory<String,Object> producerFactory() {
            return new DefaultKafkaProducerFactory<String,Object>(producerConfig());
        }

        //way to send messages

        @Bean
        public KafkaTemplate<String, Object> kafkaTemplate(ProducerFactory<String,Object> producerFactory){
         return  new KafkaTemplate<>(producerFactory);

        }
}
