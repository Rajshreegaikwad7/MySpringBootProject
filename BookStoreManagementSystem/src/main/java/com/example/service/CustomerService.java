package com.example.service;

import java.util.List;

import com.example.entity.Customer;

public interface CustomerService {
    
	public Customer saveCustomer(Customer customer);
    
    public Customer findByCustomerId(int C_Id);
    
    List<Customer> getAllCustomers();

	String deleteCustomer(int id);
	
	Customer updateCustomer(Customer customer, int id);
}
