package me.tegra.simpletoken;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import me.tegra.simpletoken.SimpleToken;
import me.tegra.simpletoken.filter.FilterInterface;
import me.tegra.simpletoken.filter.Reverse;

public class SimpleTokenTest {

	@Test
	public void shouldConvertIntegerNumberToString() {
		
		SimpleTokenInterface tt = new SimpleToken();
		
		assertEquals("should be equal", "0", tt.encode(0));
		assertEquals("should be equal", "1", tt.encode(1));
		assertEquals("should be equal", "A", tt.encode(10));
		assertEquals("should be equal", "B40", tt.encode(14400));
	}
	
	@Test
	public void shouldConvertStringEncodedValueBackToIntegers() {
		
		SimpleTokenInterface tt = new SimpleToken();
		
		assertEquals("should be equal", new Long(0), tt.decode("0"));
		assertEquals("should be equal", new Long(1), tt.decode("1"));
		assertEquals("should be equal", new Long(10), tt.decode("A"));
		assertEquals("should be equal", new Long(14400), tt.decode("B40"));
	}
	
	@Test
	public void shouldConvertNumbersWithFilters() {
		
		List<FilterInterface> filters = new ArrayList<FilterInterface>();
		filters.add(new Reverse());

		SimpleTokenInterface tt = new SimpleToken(filters);
		
		int number = 14400;
		String encoded = tt.encode(number);
		long decoded = tt.decode(encoded);
		
		assertNotEquals("shoult no be equal", "B40", encoded);
		assertEquals("should be equal", new Long(number), new Long(decoded));
	}

}
