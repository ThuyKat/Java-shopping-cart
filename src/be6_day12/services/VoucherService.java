package be6_day12.services;

import java.util.ArrayList;
import be6_day12.dto.Voucher;
import be6_day12.utilities.ReadFileUtility;

public class VoucherService {
//read Voucher file: product name, voucher code ,discount in AUD
	static String voucherFile = ShopService.voucherFile;
	public static ArrayList<Voucher> createVoucherObjects() {
		ArrayList<String[]> stringList = ReadFileUtility.readDataFile(voucherFile);
		ArrayList<Voucher> voucherList = new ArrayList<Voucher>();
		for (String[] el : stringList) {
			Voucher v = new Voucher(el[0].trim(), el[1].trim(), Double.valueOf(el[2].trim()));
			voucherList.add(v);
		}
		return voucherList;
	}

	public static void showVoucher(Voucher voucher) {
		System.out.println("DISCOUNT CODE APPLIED:"+voucher.voucherCode +": "+ voucher.voucherValue+" AUD"); 
	}
}
