package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Entity.Customer;

@Service
public interface CustomerService
{
	//for save customer
	public Customer saveCustomer(Customer customer);
	
	
	//for find any customer using their id
	public Customer findByCustomerId(int CId);
	
	//for find any customer using their name
	List<Customer>findByCustomerName(String name);
	
	//for getting all customers
	List<Customer> getAllCustomers();
	
	//for deleting customer
	String deleteCustomer(int CId);
	
	//for updating customer
	Customer updateCustomer(Customer customer, int CId);

	//for finding all customers
	public List<Customer> findAllCustomer();

	
	
}
