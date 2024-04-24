package be6_day12.services;

import java.util.ArrayList;
import java.util.Scanner;

import be6_day12.dto.Product;
import be6_day12.dto.User;
import be6_day12.dto.Voucher;

public class ShoppingCartService {
	// FUNCTION : ADD OR REMOVE ITEMS IN CART
	public static ArrayList<Product> updateCart(String productID, int selection, ArrayList<Product> selectedList) {
		
		ArrayList<Product> productList = ProductService.createProductObject();
		Scanner scan = new Scanner(System.in);
		int updatedQuantity;
		while (true) {
			System.out.println("Quantity: ");
			if (scan.hasNextInt()) {
				updatedQuantity = scan.nextInt();
				break;
			} else {
				System.out.println("Invalid input. Enter again!");
				scan.next();
			}
		}

		switch (selection) {
		case 1: // ADD TO CART
			for (Product p : productList) {
				if (p.productID.equals(productID)) {
					if (updatedQuantity > 0) {
						p.quantity = updatedQuantity;
						selectedList.add(p);
						System.out.println("Added to CART!");
						break;
					}
				}

			}
			break;
		case 2: // REMOVE FROM CART
			for (Product p : selectedList) {
				if (p.productID.equals(productID)) {
					if (updatedQuantity <= p.quantity) {
						p.quantity = p.quantity - updatedQuantity;
					}
					if (p.quantity == 0) {
						selectedList.remove(p);
					}
					System.out.println("Removed from CART!");
					break;
				}
			}
			break;
		}
		return selectedList;

	}

	public static double calculateTotal(ArrayList<Product> selectedList, int deliveryFee, double voucher) {
		double total = deliveryFee + voucher;
		for (Product item : selectedList) {
			total += item.price * item.quantity;

		}
		return total;
	}

	public static void showCart(ArrayList<Product> selectedList) {
		double total = calculateTotal(selectedList, 0, 0);
		System.out.println("shopping CART: ");
		System.out.println();
		if (selectedList.size() == 0) {
			System.out.println("shopping cart is empty");
			System.out.println();
		} else {
			System.out.printf("%-3s %-20s %-20s %-20s %-20s%n", "", "Product", "Unit Price", "Quantity", "Total");
			for (Product item : selectedList) {
				System.out.printf("%-3s %-20s %-20s %-20s %-20s%n", (selectedList.indexOf(item) + 1) + " . ",
						item.productName, item.price + " AUD", item.quantity, item.quantity * item.price);
			}
			System.out.println("TOTAL : " + total + " AUD");
			System.out.println();
		}
	}

	public static ArrayList<Product> checkOutCart(ArrayList<Product> selectedList, DeliveryService DeliveryOption,UserService userService,User u) {
		ArrayList<Voucher> voucherList = VoucherService.createVoucherObjects();
		int deliveryFee = DeliveryService.calculateDeliveryFee();
		double total = calculateTotal(selectedList, deliveryFee, 0);
		System.out.println("shopping CART: ");
		System.out.println();
		System.out.printf("%-3s %-20s %-20s %-20s %-20s%n", "", "Product", "Unit Price", "Quantity", "Total");
		for (Product item : selectedList) {
			System.out.printf("%-3s %-20s %-20s %-20s %-20s%n", (selectedList.indexOf(item) + 1) + " . ",
					item.productName, item.price + " AUD", item.quantity, item.quantity * item.price);
		}
		// PRINT DELIVERY OPTION USER CHON
		System.out.println("SHIP : " + DeliveryOption.showDeliveryTime() + " - " + deliveryFee + "AUD");

		// KIEM TRA TUNG PRODUCT TRONG CART CO CAI NAO MATCH VOI VOUCHER HAY KO? -->
		// PRINT VOUCHER, RECALCULATE TOTAL
		for (Product item : selectedList) {
			for (Voucher v : voucherList) {
				if (item.productName.equals(v.productName)) {
					VoucherService.showVoucher(v);
					total = total + v.voucherValue;
				}
			}
		}
		//SHOW RANK VA RANK DISCOUNT
		
		double totalBase = calculateTotal(selectedList,0,0);
		double rankDiscount = userService.rankDiscount(totalBase, deliveryFee);
		if(u.shop.equals("A")) {
		System.out.println( userService.showRank()+ " : "+ rankDiscount);
		total = total + rankDiscount;}
		
		
		// PRINT TOTAL
		System.out.println("TOTAL : " + total + " AUD");
		System.out.println();
		// NGUOI DUNG CHON TIEP TUC SHOPPING HOAC DAT HANG
		System.out.println("1. Place order");
		System.out.println("2. Continue shopping");
		Scanner scan = new Scanner(System.in);
		int userInput = scan.nextInt();
		if (userInput == 1) {
			System.out.println("Order is placed! Thank you... ");
			u.point += Math.floor(total);
			System.out.println("You got extra " + Math.floor(total) +" points with this purchase!");
			UserService.updateUserFile(u);
			
			return new ArrayList<Product>(); // EMPTY SHOPPING CART SAU KHI ORDER DUOC DAT THANH CONG
		}

		return selectedList; // TIEP TUC SHOPPING, LIST KO THAY DOI

	}
}
