package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Entity.Products;

@Service
public interface ProductsService 
{
	//for save products
	public Products saveProducts(Products products);
	
	//for find any products using their id
	List<Products>findByPId(int id);
	
	//get all products
	List<Products> getAllProducts();
	
	
	//for deleting products
	String deleteProducts(int id);
	
	//for updating products
	Products updateProducts(Products products,int PId);

	//for find products using their name
	
	List<Products> findByPName(String name);
	

	
	
}
