package com.naveen.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.naveen.model.User;

@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics = "naveenTopic_json", groupId = "myGroup")
	public void consume(User user) {
		LOGGER.info(String.format("Json message recieved -> %s", user.toString()));
	}
}
