package com.example.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;


@Entity
@Table(name="BakeryProducts")
public class Products
{
	@Id  //for primary key
	@GeneratedValue(strategy=GenerationType.AUTO) //for auto generation id
	private int PId;
	
	@NotBlank(message = "Invalid Name: Empty name")
	@NotNull(message = "Invalid Name: Name is NULL")
	@Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
	private String PName;
	private int PQty;
	private int PPrice;
	
	
	
	//NoArgs Constructor
	public Products() 
	{
		
		// TODO Auto-generated constructor stub
	}


	//parameterised Constructor
	
	public Products(int pId,
			@NotBlank(message = "Invalid Name: Empty name") @NotNull(message = "Invalid Name: Name is NULL") @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters") String pName,
			int pQty, int pPrice) {
		super();
		PId = pId;
		PName = pName;
		PQty = pQty;
		PPrice = pPrice;
	}

	//generating getter setter method

	public int getPId() {
		return PId;
	}


	public void setPId(int pId) {
		PId = pId;
	}


	public String getPName() {
		return PName;
	}


	public void setPName(String pName) {
		PName = pName;
	}


	public int getPQty() {
		return PQty;
	}


	public void setPQty(int pQty) {
		PQty = pQty;
	}


	public int getPPrice() {
		return PPrice;
	}


	public void setPPrice(int pPrice) {
		PPrice = pPrice;
	}
	
	
	
	
	
	
}
