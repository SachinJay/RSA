package tests;

import static modulus.ModOps.fastExp;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

class ModOpsTests
{
	@Test
	void fastExpTests()
	{
		BigInteger b2800 = new BigInteger("2800");
		BigInteger b210776 = new BigInteger("210776");
		BigInteger b19 = new BigInteger("19");
		BigInteger b496597 = new BigInteger("496597");
		BigInteger b234559 = new BigInteger("234559");
		BigInteger big = new BigInteger("10000000000000000000000000000000000000000000");

		assertEquals(BigInteger.ZERO, fastExp(BigInteger.TWO, big, BigInteger.TWO));
		assertEquals(b2800, fastExp(b210776, b19, b496597));
		assertEquals(b210776, fastExp(b2800, b234559, b496597));
	}

	@Test
	void randomTests()
	{
		BigInteger bi = new BigInteger("2000000000000000000000000000000");
		System.out.println(bi);
		bi = bi.add(bi);
		System.out.println(bi);
		System.out.println(bi.mod(new BigInteger("2")));
	}

}
