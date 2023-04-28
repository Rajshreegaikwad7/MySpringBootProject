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

import com.example.Entity.Products;
import com.example.Service.ProductsService;

@RestController
public class ProductsController 
{
	@Autowired(required=true)
	
	
	public ProductsService productsService;
	
	//to add a products
	
	@PostMapping(value="/productsvalid")
	public ResponseEntity<Products> addValidProducts(@Valid @RequestBody Products products)
	{
		return new ResponseEntity<Products>(productsService.saveProducts(products),HttpStatus.CREATED);
	}
	
	
	//to get All products
	
	@GetMapping(value="/products")
	public List<Products> getAllController()
	{
		return productsService.getAllProducts();
		
	}
	
	//for finding products by its id
	
	@GetMapping(value="/products/{id}")
	public List<Products> findByPId(@PathVariable int id)
	{
		return  productsService.findByPId(id);
	
	}
	
	//for finding  products by its name
	@GetMapping(value="/products/pname/{name}")
	public List<Products> findByPName(@PathVariable String name)
	{
		return productsService.findByPName(name);
	}
	
	
	
	//for updating products
	@PutMapping(value="/products/{id}")
	public Products updateProducts(@PathVariable int id, @RequestBody Products products)
	{
		return productsService.updateProducts(products, id);
		
	}
	
	//for deleting products
	
	@DeleteMapping(value="/products/{id}")
	public String deleteController(@PathVariable int id)
	{
		return productsService.deleteProducts(id);
	}
	
	
}
