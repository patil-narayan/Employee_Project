package com.example.EmployeeManagement.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener (
            topics = "firstTopic",
            groupId = "groupId"
    )
    void listener(String str){
        System.out.println("Listener Consumed :" +str +":)" );

    }
}
