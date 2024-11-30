package com.naveen.kafka;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.naveen.model.User;

@Service
public class UserProducer {
	private static final String TOPIC = "user_topic";
	private final KafkaTemplate<String, User> kafkaTemplate;
	private final AtomicLong idGenerator = new AtomicLong(1);

	public UserProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(User user) {
		user.setId(idGenerator.getAndIncrement());
		kafkaTemplate.send(TOPIC, user);
	}
}
