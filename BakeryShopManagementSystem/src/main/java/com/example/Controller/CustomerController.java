package com.example.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Customer;
import com.example.Service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired(required=true)
	public CustomerService customerService;
	
	//for adding a customer
	@PostMapping(value="/customervalid")
	public ResponseEntity<Customer>addValidCustomer(@Valid @RequestBody Customer customer)
	{
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
		
	}
	
	
	//to getting all customers
	@GetMapping(value="/customer")
	public List<Customer> findAllCustomer()
	{
		return customerService.findAllCustomer();
		
	}
	
	//for finding  member by its id
	
	@GetMapping(value="/customer/{id}")
	
	public Customer findCustomerById(@PathVariable int id)
	{
		return customerService.findByCustomerId(id);
	}
	
	//for finding member by its name
	
	@GetMapping("/customer/api/{name}")
	public List<Customer> findByCustomerName(@PathVariable String name) 
	{
		return customerService.findByCustomerName(name);
	}
	
	//to updating customers by id
	
	@PutMapping(value="/customer/{id}")
	public Customer updateController(@PathVariable int id, @RequestBody Customer customer)
	{
		return customerService.updateCustomer(customer, id);
		
	}

	//to deleting a customer 
	@DeleteMapping (value="/customer/{id}")
	public String deleteController(@PathVariable int id)
	{
		return customerService.deleteCustomer(id);
		
	}
	
	
}
