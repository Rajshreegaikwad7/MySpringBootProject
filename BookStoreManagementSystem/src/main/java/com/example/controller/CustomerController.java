package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.example.entity.Customer;
import com.example.service.CustomerService;

@RestController

public class CustomerController {
 
	@Autowired
	public CustomerService customerService;
	

	
	// add a customer
	@PostMapping(value = "/customers")
	public Customer addController(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	// get all customer
	@GetMapping(value = "/customers")
	public List<Customer> getAllController() {
		return customerService.getAllCustomers();
	}

	// update a customer
	@PutMapping(value = "/customers/{id}")
	public Customer updateController(@PathVariable int id, @RequestBody Customer customer) {
		return customerService.updateCustomer(customer, id);
	}

	// delete a customer

	@DeleteMapping(value = "/customers/{id}")
	public String deleteController(@PathVariable int id) {
		return customerService.deleteCustomer(id);
	}

}
