package be6_day12.entities;

public class Product {

//public int quantity; //THIS SHOULD BE MOVED INTO DTO- ITEMS IN CART
public int productID;
public String productName;
public double price;
public Product(int productID,String productName, double price) {
	
	this.productID = productID;
	this.productName = productName;
//	this.quantity = quantity;
	this.price = price;
}
}
