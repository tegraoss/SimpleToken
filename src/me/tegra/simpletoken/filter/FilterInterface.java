package me.tegra.simpletoken.filter;

public interface FilterInterface {
	public long encode(Long input);	
	public long decode(Long input);
}
