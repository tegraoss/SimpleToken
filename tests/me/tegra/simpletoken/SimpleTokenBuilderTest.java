package me.tegra.simpletoken;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleTokenBuilderTest {
	@Test
	public void builderShouldCreateAnObject() {
				
		SimpleTokenInterface tt = new SimpleTokenBuilder().addReverseFilter().Build();
		
		assertEquals("1NJCHY", tt.encode(60000000L));
		assertEquals("1THOJQ", tt.encode(60000001L));
		
		assertEquals(new Long(60000000L), tt.decode("1NJCHY"));
		assertEquals(new Long(60000001L), tt.decode("1THOJQ"));
		
	}
}
