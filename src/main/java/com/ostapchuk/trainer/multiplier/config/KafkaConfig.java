package com.ostapchuk.trainer.multiplier.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.ostapchuk.trainer.multiplier.utils.Constants.TOPIC_CLICK;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic click() {
        return TopicBuilder.name(TOPIC_CLICK)
                .replicas(1)
                .build();
    }
}
