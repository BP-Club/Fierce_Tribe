package com.nr.fierce_tribe.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dailinwei on 2020/03/06.
 */

@Component
public class KafkaConsumerService {

    @Autowired
    private SplitService splitService;

    @KafkaListener(topics = "${log.statistical.kafka.topic}", containerFactory = "kafkaListenerContainerFactory")
    public void processMessage(List<ConsumerRecord<?, ?>> records) {

        for (ConsumerRecord<?, ?> record : records) {
            String message = (String) record.value();
            splitService.saveAndSplitLog(message);
        }
    }
}
