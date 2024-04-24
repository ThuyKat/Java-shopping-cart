package be6_day12.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import be6_day12.dto.User;

public class WriteFileUtility {
	
	public static void writeDataFile(ArrayList<User> userList,String filename) {
		FileWriter writer; // moi lan write file thi write tu dau, cac du lieu cua file trc do deu bi
		// delete het
		try {
			writer = new FileWriter(filename);
			for (User u : userList) {	
				writer.write(u.ID + "," + u.password + "," + u.name + "," + u.shop +"," + u.point+ System.lineSeparator());
			}
			writer.close();
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
