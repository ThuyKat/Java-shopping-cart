package be6_day12.dto;

public class Product {
public double price;
public int quantity;
public String productID;
public String productName;
public Product(String productID,String productName, double price,int quantity) {
	
	this.productID = productID;
	this.productName = productName;
	this.quantity = quantity;
	this.price = price;
}
}
