package tests;

import static primes.PrimeOps.genPrimeCandidate;

import org.junit.jupiter.api.Test;

class PrimeOpsTests
{

	@Test
	void test()
	{
		System.out.print(genPrimeCandidate(1024));
	}

}
