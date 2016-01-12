package me.tegra.simpletoken;

public interface SimpleTokenInterface {

	String encode(long number);

	Long decode(String str);

}