package me.tegra.simpletoken.filter;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseTest {

	@Test
	public void shouldEncodeAndDecodeNumbers() {
		
		FilterInterface r = new Reverse();
		
		assertEquals("should be equal", 100441, r.encode(14400));
		assertEquals("should be equal", 14400, r.decode(100441));
		
		assertEquals("should be equal", 11, r.encode(1));
		assertEquals("should be equal", 1, r.decode(11));
	}

}
