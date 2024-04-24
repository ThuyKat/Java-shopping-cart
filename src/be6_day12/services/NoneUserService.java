package be6_day12.services;

public class NoneUserService extends UserService {

	@Override
	public String showRank() {
		return "RANK: NONE";
	}

	@Override
	public double rankDiscount(double totalBase, double deliveryBase) {
		// TODO Auto-generated method stub
		return 0;
	}

}
