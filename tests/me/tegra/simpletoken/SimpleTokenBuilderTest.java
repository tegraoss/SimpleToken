package me.tegra.simpletoken;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleTokenBuilderTest {
	@Test
	public void builderShouldCreateAnObject() {
				
		SimpleTokenInterface tt = new SimpleTokenBuilder().addReverseFilter().Build();
		
		assertEquals("2T", tt.encode(10L));
		assertEquals("33", tt.encode(11L));
		assertEquals("1NJCHY", tt.encode(60000000L));
		assertEquals("1THOJQ", tt.encode(60000001L));
		
		assertEquals("1ET7LERIYXF1", tt.encode(92233720368547758L));
		
		assertEquals(new Long(10L), tt.decode("2T"));
		assertEquals(new Long(11L), tt.decode("33"));
		assertEquals(new Long(60000000L), tt.decode("1NJCHY"));
		assertEquals(new Long(60000001L), tt.decode("1THOJQ"));
		
		assertEquals(new Long(92233720368547758L), tt.decode("1ET7LERIYXF1"));
		
	}
}
