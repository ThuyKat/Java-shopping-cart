package be6_day12.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFileUtility {
	public static ArrayList<String[]> readDataFile(String filename) {

		try {
			ArrayList<String[]> stringList = new ArrayList<>();
			File productFile = new File(filename);
			Scanner scanInput = new Scanner(productFile);
			while (scanInput.hasNextLine()) {
				String data = scanInput.nextLine();
				String[] elArray = data.split(",");
				// using trim() to cut down all whitespace around the string
				if(elArray.length != 1) { // avoid adding [] - empty array
					stringList.add(elArray);	
				}
				
			}
			return stringList;

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred when reading file. ");

		}
		return new ArrayList<String[]>();

	}
}
