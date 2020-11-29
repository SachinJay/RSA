package primes;

import java.math.BigInteger;
import java.util.Random;

import modulus.ModOps;
import utils.Constants;

public class PrimeOps
{
	/**
	 * Creates a random odd number of n bits to be used for primality testing
	 * 
	 * @param n number of bits we want in our candidate. n must be greater than 1
	 * @return BigInteger candidate of n bits
	 */
	public static BigInteger genPrimeCandidate(int n)
	{
		if (n < 2) throw new IllegalArgumentException("Number of bits in candidate must be greater than 1");

		// Want the first and last digits to be 1
		// First should be 1 to ensure we use all n bits
		// Last should be 1 to ensure it's odd
		String first;
		String last;
		first = last = "1";

		String base2RepOfCandidate = first;

		Random rand = new Random();
		for (int i = 0; i < n - 2; i++)
		{
			Integer zeroOrOne = rand.nextInt(2); // randomly produce either a 0 or 1
			base2RepOfCandidate += zeroOrOne.toString(); // add that to the string
		}
		base2RepOfCandidate += last;

		return new BigInteger(base2RepOfCandidate, 2);
	}

	/**
	 * Uses Miller-Rabin primality test to test if the candidate is prime
	 * 
	 * @param candidate the BigInteger we want to check for primality
	 * @param numTests  the number of times we should try to verify that the number
	 *                  is prime
	 * @return true if all the tests witness the primality of the candiate, false if
	 *         the candidate is composite
	 */
	public static Boolean isPrime(BigInteger candidate, int numTests)
	{
		// TODO finish implementing

		// Get the case where the candidate is 2 out of the way
		if (candidate.equals(BigInteger.TWO)) return true;

		// If the number is even, return false
		if (candidate.mod(BigInteger.TWO).equals(BigInteger.ZERO)) return false;

		// Are looking for nontrivial square roots of 1 mod candidate
		// For a witness a in [1,candidate-1], if candidate is prime then
		// a^d = 1 mod candidate or a ^{2^s * d} = -1 mod candidate
		// where n - 1 = 2^s * d with d odd
		// So for a random witness in the range, if both things don't hold, def
		// composite
		// However, if either one holds, it could be prime

		// Find s and d
		int s = 0;
		BigInteger d = candidate.subtract(BigInteger.ONE);
		while (d.mod(BigInteger.TWO) == BigInteger.ZERO) // while d is even
		{
			s++;
			d = d.divide(BigInteger.TWO);
		}

		// Do numTests tests
		for (int i = 0; i < numTests; i++)
		{
			// randomly generate a base between 1 and candidate-1
			BigInteger a = genBigInt(BigInteger.ONE, candidate.subtract(BigInteger.ONE));

			BigInteger condition = ModOps.fastExp(a, d, candidate); // a^d != 1 mod candidate test
			condition = condition.mod(candidate);

			// if first test of compositeness passed, do second test
			if (!condition.equals(BigInteger.ONE) && !condition.equals(candidate.subtract(BigInteger.ONE)))
			{
				// is a^{2^r * d} not congruent to -1 for all r from 0 to s-1
				int r = 1;
				while (r < s && !condition.equals(candidate.subtract(BigInteger.ONE)))
				{
					// TODO Implement and check that all the conditions check for equality right
					// with
					// the big integers
					condition = condition.pow(2).mod(candidate);

					if (condition.equals(BigInteger.ONE)) return false;
					r++;
				}
				if (!condition.equals(candidate.subtract(BigInteger.ONE))) return false;
			}
		}

		return true;

	}

	/**
	 * Generate a large prime number using Miller-Rabin
	 * 
	 * @param n the number of bits in the number
	 * @return the prime number
	 */
	public static BigInteger genPrime(int n)
	{
		BigInteger primeCand = BigInteger.ONE;
		Boolean isNotPrime = true;
		while (isNotPrime)
		{
			primeCand = genPrimeCandidate(n);
			isNotPrime = !isPrime(primeCand, Constants.NUM_TESTS);
		}

		return primeCand;
	}

	/**
	 * Randomly generates biginteger in the given range
	 * 
	 * @param min min value allowed
	 * @param max max value allowed
	 * @return random big int in the range
	 */
	public static BigInteger genBigInt(BigInteger min, BigInteger max)
	{
		Random rand = new Random();
		BigInteger range = max.subtract(min);
		int bitlen = range.bitLength();
		BigInteger a = new BigInteger(bitlen, rand);

		if (a.compareTo(min) < 0) a = a.add(min); // if too low, add lower limit
		if (a.compareTo(range) >= 0) a = a.mod(range).add(min); // if too high mod it and add to it

		return a;

	}

}
