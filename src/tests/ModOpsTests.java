package tests;

import static modulus.ModOps.breakUpExponent;
import static modulus.ModOps.fastExp;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ModOpsTests
{
	@Test
	void fastExpTests()
	{
		assertEquals(0, fastExp(2L, 10001L, 2));
		assertEquals(2800, fastExp(210776L, 19L, 496597L));
	}

//	@Test
	void breakUpExpTests()
	{
		System.out.println(Arrays.toString(breakUpExponent(19L)));
	}

}
