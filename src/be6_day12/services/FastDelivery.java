package be6_day12.services;

public class FastDelivery extends DeliveryService{

	@Override
	public String showDeliveryTime() {
		// TODO Auto-generated method stub
		return "Fast Delivery: 1-2 days";
	}
	public static int calculateDeliveryFee() {
		return 15;
	}

}
