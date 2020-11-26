package primes;

import java.math.BigInteger;
import java.util.Random;

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

}
