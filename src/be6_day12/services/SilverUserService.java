package be6_day12.services;

public class SilverUserService extends UserService {

	@Override
	public String showRank() {
		return "RANK SILVER: - 50% Delivery";
		
	}

	@Override
	public double rankDiscount(double totalBase, double deliveryBase) {
		 
		return -0.5*deliveryBase+0*totalBase;
	}

}
