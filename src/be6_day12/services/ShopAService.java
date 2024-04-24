package be6_day12.services;

public class ShopAService extends ShopService {
	
	public ShopAService(String productFile, String voucherFile) {
		super(productFile,voucherFile);
	}
	@Override

	public int showMenu() { 
		System.out.println("1. View shopping cart");
		System.out.println("2. View your rank and promotion"); 
		int option = showProductListAndGetUserInput();
		return option;
	}

	@Override
	public DeliveryService optionToShowDelivery() {
		// TODO Auto-generated method stub
		int selection = DeliveryService.showDeliveryOptions();
		DeliveryService DeliveryOption = DeliveryService.DeliveryOptionCreation(selection);
		return DeliveryOption;
	}
	
	
	
	

	
	
}
