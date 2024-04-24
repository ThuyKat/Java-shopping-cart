package be6_day12.services;

public class DiamondUserService extends UserService{

	@Override
	public String showRank() {
		return "RANK DIAMOND: -5% total bill ";
		
	}

	@Override
	public double rankDiscount(double totalBase, double deliveryBase) {
		
		return -0.05* totalBase + 0*deliveryBase;
	}

}
