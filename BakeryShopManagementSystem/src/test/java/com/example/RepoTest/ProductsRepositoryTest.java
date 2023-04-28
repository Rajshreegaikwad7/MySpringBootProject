package com.example.RepoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.Entity.Products;
import com.example.Repository.ProductsRepository;
import com.example.Service.ProductsService;

@SpringBootTest
public class ProductsRepositoryTest
{
	@MockBean
	private ProductsRepository productsRepository;
	
	@Autowired(required=true)
	
	private ProductsService productsService;
	
	//for test Save products method
	
	@Test
	void testSaveProducts()
	{
		Products p = new Products(101, "Cake", 1, 500);
		Mockito.when(productsRepository.save(p)).thenReturn(p);
		assertEquals(p, productsService.saveProducts(p));
	}
	
	
	//for test get All products
	@Test
	void testGetAllProducts() {
		List<Products> products = Stream.of(new Products(101, "Cake", 1, 500), new Products(101, "Cake", 1, 500))
				.collect(Collectors.toList());
		Mockito.when(productsRepository.findAll()).thenReturn(products);
		assertEquals(2, productsService.getAllProducts().size());

	}
	
	//for test delete products
	
		@Test
		void testDeleteProducts() {
			productsService.deleteProducts(101);
			Mockito.verify(productsRepository).deleteById(101);
		}
	
}
