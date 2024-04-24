package be6_day12.services;

public class SavingDelivery extends DeliveryService {

	public String showDeliveryTime() {
		return "Saving option - 3 to 5 days";
	}
	
	public static int calculateDeliveryFee() {
		return 5 ;
	}

}
