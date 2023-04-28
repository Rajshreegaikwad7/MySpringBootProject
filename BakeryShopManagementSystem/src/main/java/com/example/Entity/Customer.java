package com.example.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="Customer_Details")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int CId;
	
	@NotBlank(message = "Invalid Name: Empty name")
	@NotNull(message = "Invalid Name: Name is NULL")
	@Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters")
	private String CName;
	
	
	@NotBlank(message = "Invalid Phone number: Empty number")
	@NotNull(message = "Invalid Phone number: Number is NULL")
	@Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
	private String ContactNo;
	
	
	@Email(message="Enter valid email id")
	private String CMail;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	
	private List<Products>productsList=new ArrayList<>();
	
	
	//NoArgs Constructor
	public Customer()
	{
		
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public Customer(int cId,
			@NotBlank(message = "Invalid Name: Empty name") @NotNull(message = "Invalid Name: Name is NULL") @Size(min = 3, max = 30, message = "Invalid Name: Must be of 3 - 30 characters") String cName,
			@NotBlank(message = "Invalid Phone number: Empty number") @NotNull(message = "Invalid Phone number: Number is NULL") @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number") String contactNo,
			@Email(message = "Enter valid email id") String cMail, List<Products> productsList) {
		super();
		CId = cId;
		CName = cName;
		ContactNo = contactNo;
		CMail = cMail;
		this.productsList = productsList;
	}

	//generating getter setter method
	public int getCId() {
		return CId;
	}

	public void setCId(int cId) {
		CId = cId;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public String getContactNo() {
		return ContactNo;
	}

	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}

	public String getCMail() {
		return CMail;
	}

	public void setCMail(String cMail) {
		CMail = cMail;
	}

	public List<Products> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Products> productsList) {
		this.productsList = productsList;
	}

	
	
	
	
	
	
	
	

}
