package tests;

import static primes.PrimeOps.genPrimeCandidate;

import org.junit.jupiter.api.Test;

import utils.Constants;

class PrimeOpsTests
{

	@Test
	void test()
	{
		System.out.print(genPrimeCandidate(Constants.PRIME_BITS));
	}

}
