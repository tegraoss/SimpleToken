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
	
	public void addFilter(FilterInterface filter) {
		this.filters.add(filter);
	}
	
	private String numberToLetters(Long number) {

		StringBuilder result = new StringBuilder();
		while (number > letters.length()) {
			long rest = (long) Math.floor(number % letters.length());
			number = (long) Math.floor(number / letters.length());
			result.append(letters.charAt((int) rest));
		}
		
		result.append(letters.charAt(number.intValue()));
		
		return result.reverse().toString();
	}
	
	private Long lettersToNumber(String str) {
		Long multi = 1L; 
		Long result = 0L;
		
		str = new StringBuilder(str).reverse().toString();
		
		for(char letter: str.toCharArray()) {
			result += multi * letters.indexOf(letter);
			multi *= letters.length();
		}
		
		return result;
	}
	
	@Override
	public String encode(Long number) {
		for (int x = 0; x < filters.size(); x++) {
			number = filters.get(x).encode(number);
		}
		
		return numberToLetters(number);
	}
	
	@Override
	public Long decode(String str) {
		Long number = lettersToNumber(str);
		
		for (int x = filters.size() - 1; x >= 0; x--) {
			number = filters.get(x).decode(number);
		}
		
		return number;
	}
	
}
