package com.naveen.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic naveenTopic() {
		return TopicBuilder.name("naveenTopic")
				.build();
	}

    @Bean
    public NewTopic naveenTopicJson() {
    	return TopicBuilder.name("naveenTopic_json")
    			.build();
    }
}
