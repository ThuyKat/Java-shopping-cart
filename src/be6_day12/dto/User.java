package be6_day12.dto;

public class User {
public String ID;
public String password;
public String name;
public String shop;
public int point;

public User(String ID, String password,  String name,String shop,int point) {
	this.ID = ID;
	this.password = password;
	this.name = name;
	this.shop = shop;
	this.point = point; // to rank users
	
}

}

