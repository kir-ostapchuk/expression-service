package com.ostapchuk.trainer.multiplier.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.ostapchuk.trainer.multiplier.utils.Constants.TOPIC_CLICK;

@Service
@Log4j2
public class ProducerService {

    private final KafkaTemplate<String, LocalDateTime> kafkaTemplate;

    @Autowired
    public ProducerService(KafkaTemplate<String, LocalDateTime> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produceClick(LocalDateTime clickTime, String partition) {
        log.info("##### -> Producing message: " + clickTime);
        kafkaTemplate.send(TOPIC_CLICK, partition.hashCode(), partition, clickTime);
    }
}
