package be6_day12.dto;

public class Voucher  {
public double voucherValue;
public String voucherCode;
public String productName;
public Voucher( String voucherCode,String productName, double voucherValue) {
	this.voucherCode = voucherCode;
	this.productName = productName;
	this.voucherValue = voucherValue;
}

}
