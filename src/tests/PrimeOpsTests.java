package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static primes.PrimeOps.genPrime;
import static primes.PrimeOps.isPrime;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

class PrimeOpsTests
{

	@Test
	void test()
	{

		// Try a bunch of primes
		assertTrue(isPrime(BigInteger.TWO, 45));
		assertTrue(isPrime(new BigInteger("179"), 100));
		assertTrue(isPrime(new BigInteger("17"), 100));
		assertTrue(isPrime(new BigInteger("19"), 100));
		assertTrue(isPrime(new BigInteger("5915587277"), 100));
		assertTrue(isPrime(new BigInteger("48112959837082048697"), 100));
		assertTrue(isPrime(new BigInteger(
				"2074722246773485207821695222107608587480996474721117292752992589912196684750549658310084416732550077"),
				100));
		assertTrue(isPrime(new BigInteger(
				"2367495770217142995264827948666809233066409497699870112003149352380375124855230068487109373226251983"),
				100));

		// try some Carmichael numbers
		assertFalse(isPrime(new BigInteger("35"), 100));
		assertFalse(isPrime(new BigInteger("1595"), 100));

		// Try strong pseudoprime
		assertFalse(isPrime(new BigInteger("90751"), 100));
		assertFalse(isPrime(new BigInteger("486737"), 100));
		assertFalse(isPrime(new BigInteger("3215031751"), 100));

		System.out.println(genPrime(500));

	}

}
