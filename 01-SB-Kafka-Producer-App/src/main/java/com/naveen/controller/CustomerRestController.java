package com.naveen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.model.Customer;
import com.naveen.service.CustomerService;


@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "/addCustomer")
	public String addCustomer(@RequestBody List<Customer> customers) {
		return customerService.add(customers);
	}
}
