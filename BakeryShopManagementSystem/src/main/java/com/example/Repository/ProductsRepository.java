package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer>{

	List<Products>findByPName(String pname);
	
	List<Products>findByPId(int pid);
	
	
}
