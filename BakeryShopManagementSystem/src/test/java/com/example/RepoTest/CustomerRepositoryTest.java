package com.example.RepoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.Entity.Customer;
import com.example.Entity.Products;
import com.example.Repository.CustomerRepository;
import com.example.Service.CustomerService;

@SpringBootTest
public class CustomerRepositoryTest 
{
	@MockBean
	private CustomerRepository customerRepository;
	@Autowired(required=true)
	private CustomerService customerService;
	
	// for Test Save Customer Method
		@Test
		void testSaveCUSTOMER()
		{
			List<Products>productsList=Stream.of(new Products( 101,"Chocolate Cake",1,500),
					new Products(102,"Pineapple Cake",1,400)).collect(Collectors.toList());	
					Customer c=new Customer(1,"Rakhee","8080830287","R@gmail.com",productsList);
					Mockito.when(customerRepository.save(c)).thenReturn(c);
					assertEquals(c,customerService.saveCustomer(c));
		}
		
		//for test get all customers
		@Test
		void testGetAllCUSTOMER() {
			List<Products> productsList=Stream
					.of(new Products(101,"Chocolate Cake",1,500),
							new Products(102,"Pineapple Cake",1,400)).collect(Collectors.toList());
			List<Products> productsList1=Stream
					.of(new Products(101,"Chocolate Cake",1,500),
							new Products(102,"Pineapple Cake",1,400))
							.collect(Collectors.toList());
			
			
			List<Customer> Customer= Stream
					.of(new Customer(1,"Rakhee","8080830287","R@gmail.com",productsList),
					new Customer(2,"Rajshree","7387737090","Rajshree123@gmail.com",productsList1)).collect(Collectors.toList());
					
			Mockito.when(customerRepository.findAll()).thenReturn(Customer);
			assertEquals(2,customerService.findAllCustomer().size());
		}
		
		// for Test Delete Customer Method
		@Test
		void testDeleteCustomer() {
			customerService.deleteCustomer(1);
			Mockito.verify(customerRepository).deleteById(1);
		}

}
