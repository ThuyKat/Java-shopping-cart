package be6_day12.services;

import java.util.Scanner;

public  abstract class DeliveryService {
	
public abstract  String showDeliveryTime();
public static int calculateDeliveryFee() {
	return 10 ;
}
public static int showDeliveryOptions() {
	System.out.println("Select your delivery option below:");
	System.out.println("1.Saving");
	System.out.println("2.Basic");
	System.out.println("3.Fast");
	Scanner scan = new Scanner(System.in);
	int selection = scan.nextInt();
	return selection;	
}

public static DeliveryService DeliveryOptionCreation(int selection) {
	
	if(selection == 1) {
		return new SavingDelivery();
	}else if(selection ==2) {
		return new StandardDelivery();
	}else {return new FastDelivery();}
	
}
}
