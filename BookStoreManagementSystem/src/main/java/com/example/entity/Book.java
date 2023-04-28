package com.example.entity;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Book {
  @Id
  private int B_Id;
  private String B_Name;
  private String Author_Name;
  private int B_Qty;
  private int B_Price;
  @ManyToOne(cascade=CascadeType.ALL, fetch= FetchType.EAGER)
  @JoinColumn(name="C_Id")
  private Customer customer;
}
