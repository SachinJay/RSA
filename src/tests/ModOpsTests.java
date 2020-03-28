package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static modulus.ModOps.*;

class ModOpsTests
{

	@Test
	void remainderTests()
	{
		//5
		assertEquals(0, getRemainder(15, 5));
		assertEquals(1, getRemainder(16, 5));
		assertEquals(2, getRemainder(17, 5));
		assertEquals(3, getRemainder(18, 5));
		assertEquals(4, getRemainder(19, 5));
		assertEquals(0, getRemainder(20, 5));
		assertEquals(0, getRemainder(5, 5));
		
		//Ilegal inputs
		assertThrows(IllegalArgumentException.class, () ->{
			getRemainder(0, 7);
		});
		assertThrows(IllegalArgumentException.class, () ->{
			getRemainder(7, 0);
		});
		assertThrows(IllegalArgumentException.class, () ->{
			getRemainder(6, 7);
		});
		assertThrows(IllegalArgumentException.class, () ->{
			getRemainder(-4, 6);
		});
		assertThrows(IllegalArgumentException.class, () ->{
			getRemainder(4, -7);
		});
		assertThrows(IllegalArgumentException.class, () ->{
			getRemainder(-4, -7);
		});
	}

	@Test
	void reduceModTests()
	{
		assertEquals(0, reduceMod(0L, 5L));
		assertEquals(1, reduceMod(1L, 5L));
		assertEquals(2, reduceMod(2L, 5L));
		assertEquals(3, reduceMod(3L, 5L));
		assertEquals(4, reduceMod(4L, 5L));
		assertEquals(0, reduceMod(5L, 5L));
		assertEquals(1, reduceMod(6L, 5L));
		assertEquals(2, reduceMod(7L, 5L));
		assertEquals(3, reduceMod(8L, 5L));
		assertEquals(4, reduceMod(9L, 5L));
		assertEquals(0, reduceMod(10L, 5L));
		assertEquals(4, reduceMod(-1L, 5L));
		assertEquals(3, reduceMod(-2L, 5L));
		assertEquals(2, reduceMod(-3L, 5L));
		assertEquals(1, reduceMod(-4L, 5L));
		assertEquals(0, reduceMod(-5L, 5L));
		
		System.out.println(210776L*210776L);
		assertEquals(457959L, reduceMod(210776L*210776L,496597L));
		
		
		
		System.out.println(reduceMod(fastExp(210776L,4,496597L) * fastExp(210776L,4,496597L), 496597L));
		
		System.out.println(Long.MAX_VALUE);
		
	}

	
}
