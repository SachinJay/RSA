package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.Random;

import org.junit.jupiter.api.Test;

import driver.RSA;
import utils.Constants;

class RSATests
{

	@Test
	void test()
	{
		String msg = "Sachin Devasahayam";
		String msgUpper = msg.toUpperCase();

		assertEquals(msgUpper, RSA.deNumberify(RSA.numberify(msg)));

		for (int i = 1; i < 1000; i++)
		{
			msg = genRandString(i);
			msgUpper = msg.toUpperCase();

			assertEquals(msgUpper, RSA.deNumberify(RSA.numberify(msg)));
		}
	}

	/**
	 * Generates random string with just letters and spaces
	 * 
	 * @param len length of string to generate
	 * @return the generated string
	 */
	public static String genRandString(int len)
	{
		String ret = "";

		int max = Constants.CIPHER_RADIX;
		int min = 1;
		Random rand = new Random();

		for (int i = 0; i < len; i++)
		{
			Integer randNum = rand.nextInt(max - min) + min;
			BigInteger randBig = new BigInteger(randNum.toString());
			ret = ret + RSA.deNumberify(randBig);
		}

		return ret;
	}

}
