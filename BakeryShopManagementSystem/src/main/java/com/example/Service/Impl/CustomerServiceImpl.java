package com.example.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Customer;
import com.example.Repository.CustomerRepository;
import com.example.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired(required=true)
	
	
	private CustomerRepository customerRepository;
	
	//for save customer
	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	//for find customer using their id
	@Override
	public Customer findByCustomerId(int CId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(CId).get();
	}

	//for getting all customer
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
				}

	//for delete customer
	@Override
	public String deleteCustomer(int id) {
		// TODO Auto-generated method stub
		 customerRepository.deleteById(id);
		 return "The Customer with id"+  id  +"Has been deleted....";
	}

	//for updating customer
	@Override
	public Customer updateCustomer(Customer customer, int id) {
		// TODO Auto-generated method stub
		Customer _customer=customerRepository.findById(id).get();
		_customer.setCName(customer.getCName());
		return customerRepository.save(customer);
	


	}

	//for finding all customer
	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	//for find any customer using their name
	@Override
	public List<Customer> findByCustomerName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByCName(name);
	}

	

}
