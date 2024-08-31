package com.naveen.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.naveen.model.Customer;
import com.naveen.util.KafkaConstants;


@Service("customerService")
public class CustomerService {

	@KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID)
	public Customer listener(Customer c) {
		System.out.println("***Msg recieved from Kafka Topic ::" + c);
		return c;
	}

}
