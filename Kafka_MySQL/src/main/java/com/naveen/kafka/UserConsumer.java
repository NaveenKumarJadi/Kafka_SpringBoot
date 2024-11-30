package com.naveen.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.naveen.model.User;
import com.naveen.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserConsumer {

	private final UserRepository userRepository;

	public UserConsumer(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@KafkaListener(topics = "user_topic", groupId = "user_group")
	public void consume(User user) {
		
		user.setId(null);
		userRepository.save(user);
		log.info("Consumed and saved user : {} ", user);
//		System.out.println("Consumed and saved user: " + user);
	}
}
