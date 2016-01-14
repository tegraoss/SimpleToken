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
		
		assertEquals("0", tt.encode(0L));
		assertEquals("1", tt.encode(1L));
		assertEquals("A", tt.encode(10L));
		assertEquals("B40", tt.encode(14400L));
		assertEquals("11LOCU", tt.encode(63157134L));
	}
	
	@Test
	public void shouldConvertStringEncodedValueBackToLongs() {
		
		SimpleTokenInterface tt = new SimpleToken();
		
		assertEquals(new Long(0L), tt.decode("0"));
		assertEquals(new Long(1L), tt.decode("1"));
		assertEquals(new Long(10L), tt.decode("A"));
		assertEquals(new Long(14400L), tt.decode("B40"));
		assertEquals(new Long(63157134L), tt.decode("11LOCU"));
		
	}
	
	@Test
	public void shouldConvertNumbersWithFilters() {
		
		List<FilterInterface> filters = new ArrayList<FilterInterface>();
		filters.add(new Reverse());

		SimpleTokenInterface tt = new SimpleToken(filters);
		
		long number = 14400L;
		String encoded = tt.encode(number);
		long decoded = tt.decode(encoded);
		
		assertNotEquals("shoult no be equal", "B40", encoded);
		assertEquals("should be equal", new Long(number), new Long(decoded));
	}

}
