package be6_day12.services;

public class StandardDelivery extends DeliveryService {

	@Override
	public String showDeliveryTime() {
		// TODO Auto-generated method stub
		return " Standard options : 5 to 7 days";
	}
	public static int calculateDeliveryFee() {
		return 10;
	}

}
