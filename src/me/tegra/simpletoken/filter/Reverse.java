package me.tegra.simpletoken.filter;

public class Reverse implements FilterInterface {

	@Override
	public long encode(long input) {
		String strNumber = new Long(input).toString();
		String reversedNumber = new StringBuilder(strNumber).append("1").reverse().toString();
		return Long.parseLong(reversedNumber);
	}
	
	@Override
	public long decode(long input) {
		String strNumber = new Long(input).toString().substring(1);
		String reversedNumber = new StringBuilder(strNumber).reverse().toString();
		return Long.parseLong(reversedNumber);
	}

}
