package be6_day12.services;

import java.util.ArrayList;
import java.util.Scanner;

import be6_day12.dto.User;
import be6_day12.utilities.ReadFileUtility;

public abstract class ShopService {	
public static String productFile;
public static String voucherFile;
public ShopService(String productFile, String voucherFile) {
	this.productFile = productFile;
	this.voucherFile = voucherFile;	
}
public abstract int showMenu();
	
//different product data file
// different checkout: show delivery option or not show
//voucherList
//voucher application

public static User logInUser() {
	// USER INPUT USERID AND PASSWORD
	boolean validation = false;
	User u = null;
	while (validation == false) {
		Scanner scanInput = new Scanner(System.in);
		System.out.println("UserID : ");
		String idInput = scanInput.nextLine();
		System.out.println("Password: ");
		String passInput = scanInput.nextLine();
		// user.txt: USERID AND PASSWORD MATCHED ? SHOP ATTRIBUTE = SHOP A/SHOP B--> NEW
		// OBJECT SHOP A/B
		ArrayList<String[]> userList = ReadFileUtility.readDataFile("user.txt");
		for (String[] el : userList) {
			if (el[0].trim().equals(idInput) && el[1].trim().equals(passInput)) {
				System.out.println(" Welcome " + el[2] + "!");
				System.out.println();
				validation = true;
				 u =  new User(el[0].trim(),el[1].trim(),el[2].trim(),el[3].trim(),Integer.valueOf(el[4].trim()));
				break;
			}
		}
		if (validation == false) {
			System.out.println("Invalid username or password!Try again");
		}
	}
	return u;
	
	
}
protected static int showProductListAndGetUserInput() {
	ProductService.printProductList();
	int option;

	while (true) {
		System.out.println("Enter your selection: ");
		Scanner scanOption = new Scanner(System.in);
		if (scanOption.hasNextInt()) {
//			if(scanOption.nextInt() != 0) {
			option = scanOption.nextInt();
			if (option > 6 || option < 1) {
				System.out.println("Invalid Input.Please try again");

			} else {
				break;
			}

		} else {
			System.out.println("Invalid Input.Please try again");
			scanOption.next();
		}
	}
	return option; 
}

public static ShopService classifyShop(String shop) {
	// TODO Auto-generated method stub
	if(shop.equals("A")) {
		return new ShopAService("productA.txt","voucherA.txt");
	}else {
		return new ShopBService("productB.txt","voucherB.txt");
	}
}

public abstract DeliveryService optionToShowDelivery();


 
}
