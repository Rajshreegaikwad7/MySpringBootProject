package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
@Service
public class CustomerServiceimpl implements CustomerService{
	@Autowired
	public CustomerRepository customerRepository;

    @Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer, int id) {
		// TODO Auto-generated method stub
		Customer _customer = customerRepository.findById(id).get();
		_customer.setC_Name(customer.getC_Name());
	    return customerRepository.save(_customer);
	}

	@Override
	public String deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
		return "the book with id " + id + " has been deleted...";
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Customer findByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId).get();
	}

	
}
