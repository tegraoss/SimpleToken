package me.tegra.simpletoken.filter;

public class Reverse implements FilterInterface {

	@Override
	public long encode(Long input) {
		String strNumber = input.toString();
		String reversedNumber = new StringBuilder(strNumber).append("1").reverse().toString();
		return Long.parseLong(reversedNumber);
	}
	
	@Override
	public long decode(Long input) {
		String strNumber = input.toString().substring(1);
		String reversedNumber = new StringBuilder(strNumber).reverse().toString();
		return Long.parseLong(reversedNumber);
	}

}
