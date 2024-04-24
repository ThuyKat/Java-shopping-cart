package be6_day12;

import java.util.ArrayList;
import java.util.Scanner;
import be6_day12.dto.Product;
import be6_day12.dto.User;
import be6_day12.services.DeliveryService;
import be6_day12.services.ProductService;
import be6_day12.services.ShopService;
import be6_day12.services.ShoppingCartService;
import be6_day12.services.UserService;


public class MAIN {
	

	public static void main(String[] args) {
		final int VIEW_CART = 1;
		final int VIEW_RANK = 2;
		
		// LOG-IN USER : doc file user.txt co userID va password, doi chieu voi input	
		User u = ShopService.logInUser();
		
		ShopService shopService = ShopService.classifyShop(u.shop);
		UserService userService = UserService.userRank(u.point);
		
		// KHI LOG-IN THANH CONG, SHOW MENU CHO USER CHON
		ArrayList<Product> selectedList = new ArrayList<>();
		
		
		while (u.shop != null) {
			int option = shopService.showMenu();
			switch (option) {
			case VIEW_CART:
				ShoppingCartService.showCart(selectedList);
				// NEU CART CO ITEMS THI HOI CO CHECKOUT KO?
				while (selectedList.size() != 0) {
					System.out.println("Do you want to check out? (Y/N)");
					Scanner scan = new Scanner(System.in);
					String userAns = scan.nextLine();
					if (userAns.equals("Y")|| userAns.equals("y")) {
						DeliveryService DeliveryOption = shopService.optionToShowDelivery();
						selectedList = ShoppingCartService.checkOutCart(selectedList, DeliveryOption, userService,u); //EMPTY CART AFTER CHECKOUT
						break;
					} else if (userAns.equals("N")|| userAns.equals("n")) {
						break;
					} else {
						System.out.println("Please try again ");
					}
				}
				break;
			case VIEW_RANK://MAKE THE VIEW_RANK OPTION ONLY AVAILABLE TO SHOP A
				if(u.shop.equals("A")) {
				System.out.println(userService.showRank());
				break;
				} 
			default: // KHI USER CHON PRODUCT
				// show Product menu: 1.ADD TO SHOPPING CART 2.REMOVE FROM SHOPPING CART
				// cap nhat vao shopping cart
				int selection = ProductService.showProductMenu();
				selectedList = ShoppingCartService.updateCart(String.valueOf(option), selection, selectedList);
			}
		}

	}

}
