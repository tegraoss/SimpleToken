package me.tegra.simpletoken;

public interface SimpleTokenInterface {

	String encode(Long number);

	Long decode(String str);

}