package me.tegra.simpletoken;

import java.util.ArrayList;
import java.util.List;

import me.tegra.simpletoken.filter.FilterInterface;

public final class SimpleToken implements SimpleTokenInterface {

	private final String letters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";	
	private final List<FilterInterface> filters;
	
	public SimpleToken() {
		this.filters = new ArrayList<FilterInterface>();
	}
	
	public SimpleToken(List<FilterInterface> filters) {
		if (null == filters) {
			this.filters = new ArrayList<FilterInterface>();
			return;
		}
		
		this.filters = filters;
	}
	
	private String numberToLetters(long number) {

		StringBuilder result = new StringBuilder();
		while (number > letters.length()) {
			int rest = (int) Math.floorMod(number, letters.length());
			number = Math.floorDiv(number, letters.length());
			result.append(letters.charAt((int) rest));
		}
		
		result.append(letters.charAt((int)number));
		
		return result.reverse().toString();
	}
	
	private long lettersToNumber(String str) {
		int multi = 1; 
		long result = 0;
		
		str = new StringBuilder(str).reverse().toString();
		
		for(char letter: str.toCharArray()) {
			result += multi * letters.indexOf(letter);
			multi *= letters.length();
		}
		
		return result;
	}
	
	@Override
	public String encode(long number) {
		for (int x = 0; x < filters.size(); x++) {
			number = filters.get(x).encode(number);
		}
		
		return numberToLetters(number);
	}
	
	@Override
	public Long decode(String str) {
		long number = lettersToNumber(str);
		
		for (int x = filters.size() - 1; x >= 0; x--) {
			number = filters.get(x).decode(number);
		}
		
		return number;
	}
	
}
