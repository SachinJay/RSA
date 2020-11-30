package utils;

import java.math.BigInteger;

public class Constants
{
	public static final int PRIME_BITS = 1024;
	public static final int NUM_TESTS = 127;

	/**
	 * Common encryption key
	 */
	public static final BigInteger COMMON_E = new BigInteger("65537");

	/**
	 * When making plaintext into numbers, use this base Why? Because 26 letters and
	 * a space so need 28 digits because we don't want to use the digit 0 as it
	 * could be lost with leading zeros
	 */
	public static final int CIPHER_RADIX = 28;

	/**
	 * Since we're in a base 28 system, the last digit is r If the radix changes,
	 * must change this as well
	 */
	public static final String LAST_DIG = "r";

}
