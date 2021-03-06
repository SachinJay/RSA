package tests;

import static modulus.ModOps.extendedEuclid;
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

	@Test
	void extendedEuclidTests()
	{
		BigInteger e = new BigInteger("5");
		BigInteger phi = new BigInteger("1");

		BigInteger[] arr = extendedEuclid(e, phi);
		assertEquals(BigInteger.ONE, arr[0]);
		assertEquals(BigInteger.ZERO, arr[1]);
		assertEquals(BigInteger.ONE, arr[2]);

		e = new BigInteger("234559");
		Integer intermed = 786 * 630;
		phi = new BigInteger(intermed.toString());
		BigInteger expectedInv = new BigInteger("19");

		arr = extendedEuclid(e, phi);
		assertEquals(BigInteger.ONE, arr[0]);
		assertEquals(expectedInv, arr[1]); // decryption key
		arr = extendedEuclid(phi, e);
		assertEquals(BigInteger.ONE, arr[0]);
		assertEquals(expectedInv, arr[2]);
	}

}
