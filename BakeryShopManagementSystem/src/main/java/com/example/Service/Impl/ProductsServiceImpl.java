package com.example.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Products;
import com.example.Repository.ProductsRepository;
import com.example.Service.ProductsService;

@Service
public class ProductsServiceImpl  implements ProductsService
{
	
	@Autowired(required=true)
	
	private ProductsRepository productsRepository;

	//for save products
	@Override
	public Products saveProducts(Products products) {
		// TODO Auto-generated method stub
		return productsRepository.save(products);
	}

	

	//for getting all products
	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return productsRepository.findAll();
	}

	//for deleting products
	@Override
	public String deleteProducts(int id) {
		// TODO Auto-generated method stub
		 productsRepository.deleteById(id);
		 return "The product with id"+  id  + "Has been deleted....";
	}

	//for updating products
	@Override
	public Products updateProducts(Products products, int PId) {
		// TODO Auto-generated method stub
		Products _products=productsRepository.findByPId(PId).get(PId);
		_products.setPName(products.getPName());
		
		return productsRepository.save(products);
	}

	//for find products using their name

	@Override
	public List<Products> findByPName(String name) {
		// TODO Auto-generated method stub
		return productsRepository.findByPName(name);
	}

	//for find products using their id
	@Override
	public List<Products> findByPId(int pid) {
		// TODO Auto-generated method stub
		return productsRepository.findByPId(pid);
	}

	
	
	

}
