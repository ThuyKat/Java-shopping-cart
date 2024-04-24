package be6_day12.services;

import java.util.ArrayList;

import be6_day12.dto.User;
import be6_day12.utilities.ReadFileUtility;
import be6_day12.utilities.WriteFileUtility;

public abstract class UserService {
//classifyRank()
//readUserFileToFindRank()
//Abtract:generateVoucher()
//showRankandPromo()
	
	public static UserService userRank(double point) {
		if(point <50 && point>0) {
			return new SilverUserService();
		}else if(point>=50 && point<=100) {
			return new GoldUserService();
		}else if(point >100) {
			return new DiamondUserService();
		}else {
		return new NoneUserService();}
	}
	public static void updateUserFile(User currentU) {
		ArrayList<String[]> stringUserList = ReadFileUtility.readDataFile("user.txt");
		ArrayList<User>userList = new ArrayList<User>();
		for (String[] el : stringUserList) {
			User u = new User(el[0].trim(),el[1].trim(),el[2].trim(),el[3].trim(),Integer.valueOf(el[4].trim()));
			userList.add(u);
		}
		for (User u : userList) {
			if (u.ID.equals(currentU.ID)) {
				u.point = currentU.point;
				break;
			}
		WriteFileUtility.writeDataFile(userList, "user.txt");
		System.out.println("Point is updated");
		}
		
		
	}
	public abstract String showRank();
	public abstract double rankDiscount(double totalBase,double deliveryBase);
}
