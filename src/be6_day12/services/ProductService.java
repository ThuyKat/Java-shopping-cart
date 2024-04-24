package be6_day12.services;

import java.util.ArrayList;
import java.util.Scanner;

import be6_day12.dto.Product;
import be6_day12.utilities.ReadFileUtility;

public class ProductService {
	
	static String productFile = ShopService.productFile;
	
	public static ArrayList<Product> createProductObject() {
		ArrayList<String[]> stringList = ReadFileUtility.readDataFile(productFile);
		ArrayList<Product> productList = new ArrayList<Product>();
		for (String[] el : stringList) {
			Product p = new Product(el[0].trim(), el[1].trim(), Double.valueOf(el[2].trim()),
					Integer.valueOf(el[3].trim()));
			productList.add(p);
		}
		return productList;
	}

	 public static void printProductList() {
		ArrayList<Product> productList = createProductObject();
		for (Product p : productList) {
			System.out.println(p.productID + ". " + p.productName + " : " + p.price + " AUD");
		}
	}

//showProductMenu()
	public static int showProductMenu() {
		System.out.println("1. Add to shopping cart");
		System.out.println("2. Remove from shopping cart");
		System.out.println("Enter your selection: ");
		int selection;

		while (true) {
			Scanner scan = new Scanner(System.in);
			if (scan.hasNextInt()) {

				selection = scan.nextInt();
				if (selection > 2 || selection < 1) {
					System.out.println("Invalid Input.Please try again");

				} else {break;}

			} else {
				System.out.println("Invalid Input.Please try again");
				scan.next();
			}
		}
		return selection;

	}

}
