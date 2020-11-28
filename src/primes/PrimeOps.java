package primes;

import java.math.BigInteger;
import java.util.Random;

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
		if (candidate.toString().equals(BigInteger.TWO.toString())) return true;

		// If the number is even, return false
		if (candidate.mod(BigInteger.TWO).toString() == BigInteger.ZERO.toString()) return false;

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
			// randomly generate a base
			BigInteger a = new BigInteger();

			BigInteger first = a.pow(Integer.parseInt(d.toString())); // a^d != 1 mod candidate test
			first = first.mod(candidate);

			if (first.toString() != BigInteger.ONE.toString()
					&& first.toString() != candidate.subtract(BigInteger.ONE).toString()) // if first test of
																							// compositeness passed, do
																							// second test
			{
				// is a^{2^r * d} not congruent to -1 for all r from 0 to s-1
				int r = 1;
				while (r < s && first != BigInteger.ONE)
				{
					// TODO Implement and check that all the conidions check for equality right with
					// the big integers
				}
			}

		}

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

}
