package com.naveen.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.kafka.UserProducer;
import com.naveen.model.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
    private final UserProducer userProducer;

    public UserController(UserProducer userProducer) {
        this.userProducer = userProducer;
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        userProducer.sendMessage(user);
        return "User sent to Kafka";
    }
}
