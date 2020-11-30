package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import driver.RSA;

class RSATests
{

	@Test
	void test()
	{
		String msg = "Sachin Devasahayam";
		String msgUpper = msg.toUpperCase();

		assertEquals(msgUpper, RSA.deNumberify(RSA.numberify(msg)));
	}

}
