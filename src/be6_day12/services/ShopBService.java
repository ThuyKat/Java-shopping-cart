package be6_day12.services;


public class ShopBService extends ShopService{
	

	public ShopBService(String productFile, String voucherFile) {
		super(productFile, voucherFile);
		
	}


	@Override
	public int showMenu() { // show Menu khac nhau cho shop A va shop B?
		System.out.println("1. View shopping cart");
		int option = showProductListAndGetUserInput();
		return option;
	}
	

	@Override
	public DeliveryService optionToShowDelivery() {
		return new StandardDelivery();
	}

}
