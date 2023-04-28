package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int C_Id;
   private String C_Name;
   private String C_Gender;
   private String C_Email;
   @OneToMany(fetch = FetchType.EAGER, mappedBy="customer",cascade=CascadeType.ALL)
   @JsonIgnoreProperties("customer")
   private List<Book> bookList = new ArrayList<>();
   
}
