package me.tegra.simpletoken.filter;

public interface FilterInterface {
	public long encode(long input);	
	public long decode(long input);
}
