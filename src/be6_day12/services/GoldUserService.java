package be6_day12.services;

public class GoldUserService extends UserService {

	@Override
	public String showRank() {
		return "RANK GOLD: -2% total bill";
		
	}

	@Override
	public double rankDiscount(double totalBase,double deliveryBase) {
		
		return  -0.02 * totalBase + 0*deliveryBase;
	}

}
